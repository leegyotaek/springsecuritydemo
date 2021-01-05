package com.hitaek.springSecurityDemo.service;

import com.hitaek.springSecurityDemo.entity.User;
import com.hitaek.springSecurityDemo.user.CrmUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);


    void save(CrmUser theCrmUser);
}
