package com.sysco.margin.heirarchy

import com.sysco.margin.common.BaseEntity
import com.sysco.margin.security.User

class Customer extends BaseEntity{

	String idsId
	String name

	String billingStreetNumber
	String billingStreetName
	String billingPostal
	String billingState

	String deliveryStreetNumber
	String deliveryStreetName
	String deliveryPostal
	String deliveryState

	String phone1
	String fax1

	//idLevel defined for the internal program use.
	//Like for MA Margin Management to identify the navigator Hierarchy
	Integer idLevel

	String maID
	String customerRank

	User user

	static constraints = {
		idsId nullable:true
		name nullable:true

		billingStreetNumber nullable:true
		billingStreetName nullable:true
		billingPostal nullable:true
		billingState nullable:true

		deliveryStreetNumber nullable:true
		deliveryStreetName nullable:true
		deliveryPostal nullable:true
		deliveryState nullable:true

		phone1 nullable:true
		fax1 nullable:true

		//idLevel defined for the internal program use.
		//Like for MA Margin Management to identify the navigator Hierarchy
		idLevel nullable:true

		maID nullable:true
		customerRank nullable:true

		user nullable:true
	}
}
