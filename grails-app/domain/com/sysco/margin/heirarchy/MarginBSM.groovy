package com.sysco.margin.heirarchy

import com.sysco.margin.common.BaseEntity
import com.sysco.margin.security.User

class MarginBSM extends BaseEntity{

	String name
	String code
	User user
	static constraints = { user nullable:true }
}
