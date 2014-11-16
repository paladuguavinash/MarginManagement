package com.sysco.margin.common


/**
 * @author Dominic Evans
 *
 */
abstract class BaseController {

	def springSecurityService

	def loggedInUser

	def getLoggedInUser(){
		this.loggedInUser = session?.loggedInUser
		log.debug "Setting the loggedInUser from the session access in controllers :: ${loggedInUser?.id}"
		return loggedInUser
	}
}