package com.sysco.margin.common

abstract class BaseService{

	Class entityClass
	def springSecurityService

	BaseService(){
	}

	BaseService(def entity){
		this.entityClass = entity
	}

	/**
	 * Saves the entity.
	 * Eg: super.save(DomainObj) or serviceClass.save(DomainObj)
	 * 
	 * @param entity - takes a domain class
	 * 
	 */
	def save(def entity){
		log.info "Processing the entity : ${entity}"
		entity.save(failOnError:true, flush:true)
		log.info "Entity Saved : ${entity}"
	}
}