package com.sysco.margin.heirarchy

import com.sysco.margin.common.BaseEntity
import com.sysco.margin.security.User

class MarginAssociate extends BaseEntity{

	String name
	String code
	User user

	static hasMany = [customers: Customer]
	static belongsTo = MarginDSM

	static constraints = { user nullable:true }
}
