package com.sysco.margin.common

import com.sysco.margin.security.Role
import com.sysco.margin.security.User
import com.sysco.margin.security.UserRole

class AccountService extends BaseService{

	def create(entity){
		//create user account
		def userAccount = new User()
		userAccount.username = entity.name + "_" + entity.code
		userAccount.password = "password"
		userAccount.type = entity.type
		save(userAccount)
		userAccount.role = entity.type
		createRole(userAccount)
		entity.user = userAccount
		save(entity)
	}

	def createRole(user){
		def role = Role.findByAuthority("ROLE_${user.role.toUpperCase()}")
		UserRole.create(user, role, true)
	}
}
