package com.sysco.margin.common

import grails.validation.Validateable

import org.apache.commons.collections.ListUtils

import com.sysco.margin.heirarchy.Customer
import com.sysco.margin.heirarchy.MarginAssociate
import com.sysco.margin.heirarchy.MarginBSM
import com.sysco.margin.heirarchy.MarginDSM
import com.sysco.margin.heirarchy.MarginRSM

@Validateable
class AccountCommand {

	List<MarginBSM> bsms = ListUtils.lazyList([], { new MarginBSM() } )//[].withLazyDefault{new MarginBSM()}
	List<MarginRSM> rsms = ListUtils.lazyList([], {new MarginRSM()})
	List<MarginDSM> dsms = ListUtils.lazyList([], {new MarginDSM()})
	List<MarginAssociate> mas = ListUtils.lazyList([], {new MarginAssociate()})
	List<Customer> customers = ListUtils.lazyList([], {new Customer()})
	/*List<MarginBSM> bsms = ListUtils.lazyList([], { new MarginBSM() } as Factory)
	 List<MarginRSM> rsms = ListUtils.lazyList([], {new MarginRSM()} as Factory)
	 List<MarginDSM> dsms = ListUtils.lazyList([], {new MarginDSM()} as Factory)
	 List<MarginAssociate> mas = ListUtils.lazyList([], {new MarginAssociate()} as Factory)*/
	String atype
	Long associateType

	String code


	static constraints = {
		bsms nullable: true
		rsms nullable: true
		dsms nullable: true
		mas nullable: true
	}
}
