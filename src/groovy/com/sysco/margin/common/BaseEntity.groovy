package com.sysco.margin.common


abstract class BaseEntity {

	static dynamicProperties = true
	static searchable = true

	Long createdBy
	Date createdOn

	transient springSecurityService

	static transients = ['springSecurityService']
	def storage = [:]

	static constraints = {}

	def beforeValidate(){
		initDefaults()
	}

	def beforeInsert() {
		initDefaults()
	}

	def beforeUpdate() {
		initDefaults()
	}

	def initDefaults(){
		if(!createdBy){
			createdBy = springSecurityService.currentUser ? springSecurityService.currentUser.id : 0
		}
		if(!createdOn){
			createdOn = new Date()
		}
	}

	def propertyMissing(String name, value) {
		storage[name] = value
	}
	
	def propertyMissing(String name) {
		storage[name]
	}
}