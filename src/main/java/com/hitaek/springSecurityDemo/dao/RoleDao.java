package com.hitaek.springSecurityDemo.dao;


import com.hitaek.springSecurityDemo.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
