import com.sysco.margin.security.User

class MMFilters {

	def springSecurityService
	def dataSource

	def filters = {
		secureFilterUrl(url:"/**") {
			before = {
				def isLoggedIn = springSecurityService.isLoggedIn()
				log.info "Checking if the url has an loggedInUser :: ${isLoggedIn}"
				if(isLoggedIn){
					def principal = springSecurityService.getAuthentication().getPrincipal();
					log.info "Setting the session for the loggedInUser for account :: ${principal.username}"

					if (principal != null && principal != 'anonymousUser') {
						def loggedInUser
						def user = User.findByUsername(principal.username)
						loggedInUser = User.get(user.id)
						session.loggedInUser = loggedInUser
					}
				}
			}
			after = { Map model ->
				def principal = springSecurityService.getAuthentication().getPrincipal();
				if (principal != null && principal != 'anonymousUser') {
					model?.loggedInUser = session.loggedInUser
				}
			}
			afterView = { Exception e ->
			}
		}
	}
}
