package com.sysco.margin.common

import grails.converters.JSON

import org.springframework.security.access.annotation.Secured

import com.sysco.margin.heirarchy.MarginAssociate
import com.sysco.margin.heirarchy.MarginBSM
import com.sysco.margin.heirarchy.MarginDSM
import com.sysco.margin.heirarchy.MarginRSM

@Secured(["ROLE_ADMIN"])
class AdminController extends BaseController{

	def accountService

	def index(){
		render view:"/account/form", model:[accountCmd: new AccountCommand()]
	}

	def createUser(AccountCommand accountCmd){
		if(accountCmd.atype == "BSM"){
			accountCmd.bsms.each{
				if(it){
					it.type = accountCmd.atype
					accountService.create(it)
				}
			}
		}

		if(accountCmd.atype == "RSM"){
			def bsm = MarginBSM.get(accountCmd.associateType)
			accountCmd.rsms.each{
				if(it){
					it.bsm = bsm
					it.type = accountCmd.atype
					accountService.create(it)
				}
			}
		}

		if(accountCmd.atype == "DSM"){
			def rsm = MarginRSM.get(accountCmd.associateType)
			accountCmd.dsms.each{
				it.type = accountCmd.atype
				rsm.addToDsms(it)
				accountService.create(it)
			}
		}

		if(accountCmd.atype == "MA"){
			def dsm = MarginDSM.get(accountCmd.associateType)
			accountCmd.mas.each{
				if(it){
					it.type = accountCmd.atype
					dsm.addToMas(it)
					accountService.create(it)
				}
			}
		}

		if(accountCmd.atype == "CUSTOMER"){
			def associate = MarginAssociate.get(accountCmd.associateType)
			accountCmd.customers.each{
				if(it){
					it.type = accountCmd.atype
					associate.addToCustomers(it)
					accountService.create(it)
				}
			}
		}

		redirect action:"index"
	}

	def populateUsers(){
		def type = params.type
		def results = []
		if(type == "RSM"){
			results = MarginBSM.list()
		}
		if(type == "DSM"){
			results = MarginRSM.list()
		}
		if(type == "MA"){
			results = MarginDSM.list()
		}
		if(type == "CUSTOMER"){
			results = MarginAssociate.list()
		}
		results.add(type)

		render results as JSON
	}
}
