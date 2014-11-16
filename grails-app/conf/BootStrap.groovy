import com.sysco.margin.security.Role
import com.sysco.margin.security.User
import com.sysco.margin.security.UserRole

class BootStrap {

	def init = { servletContext ->

		def roles = [
			"ROLE_BSM",
			"ROLE_RSM",
			"ROLE_DSM",
			"ROLE_MA",
			"ROLE_CUSTOMER",
			"ROLE_ADMIN"
		]
		def dbRoles = Role.list()*.authority
		def adminUser = User.findByUsername("admin") ?: new User(username:"admin", password:"password", enabled:"true", type:"test").save()
		if(!dbRoles.containsAll(roles)){
			roles.each{
				def role = new Role(authority:it).save()
				UserRole.create(adminUser, role)
			}
		}
	}
	def destroy = {
	}
}
