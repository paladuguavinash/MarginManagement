package com.sysco.margin.heirarchy

import com.sysco.margin.common.BaseEntity
import com.sysco.margin.security.User

class MarginRSM extends BaseEntity{

	String name
	String code
	MarginBSM bsm
	User user

	static hasMany = [dsms: MarginDSM]
	static constraints = { user nullable:true }
}