package com.sysco.margin.common

import grails.plugin.springsecurity.annotation.Secured

import com.sysco.margin.heirarchy.Customer
import com.sysco.margin.heirarchy.MarginAssociate
import com.sysco.margin.heirarchy.MarginBSM
import com.sysco.margin.heirarchy.MarginDSM
import com.sysco.margin.heirarchy.MarginRSM

@Secured(["ROLE_ADMIN","ROLE_BSM",
	"ROLE_RSM",
	"ROLE_DSM",
	"ROLE_MA",
	"ROLE_CUSTOMER"])
class HomeController extends BaseController{

	def springSecurityService

	def index(){
		def user = loggedInUser
		def type
		def results = []
		def userType
		if(user.type != "test"){
			if(user.type == "BSM"){
				type = MarginBSM.findByUser(user)
				def rsms = MarginRSM.findAllByBsm(type)
				results = rsms
			}
			if(user.type == "RSM"){
				type = MarginRSM.findByUser(user)
				def rsms = type.dsms.each{d->
					d.mas = d.mas
				}
				results = rsms
			}
			if(user.type == "DSM"){
				type = MarginDSM.findByUser(user)
				results =  type.mas
			}
			if(user.type == "MA"){
				type = MarginAssociate.findByUser(user)
				results =  type.customers
			}
			if(user.type == "Customer"){
				type = Customer.findByUser(user)
			}
		}

		render view:"index", model:[results:results, type:type, userType:userType]
	}
	
	def details(){
		
	}
}
