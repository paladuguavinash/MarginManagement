package com.sysco.margin.heirarchy

import com.sysco.margin.common.BaseEntity
import com.sysco.margin.security.User

class MarginDSM extends BaseEntity{

	String name
	String code
	User user

	static hasMany = [mas: MarginAssociate]
	static belongsTo = MarginRSM
	static constraints = { user nullable:true }
}
