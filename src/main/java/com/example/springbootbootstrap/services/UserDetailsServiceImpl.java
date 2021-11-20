package com.example.springbootbootstrap.services;

import com.example.springbootbootstrap.model.Role;
import com.example.springbootbootstrap.model.User;
import com.example.springbootbootstrap.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserService userService;

    public UserDetailsServiceImpl() {}

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.findByName(s);
        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), user.getPassword(),
                true, true, true, true,
                getAuthorities(user.getRoleList())
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            for (Role role: roles) {
                authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
            }
            return authorities;
        }
}
