package com.hitaek.springSecurityDemo.dao;


import com.hitaek.springSecurityDemo.entity.User;
import com.hitaek.springSecurityDemo.user.CrmUser;

public interface UserDao {

    User findByUserName(String userName);

    void save(User user);
}
