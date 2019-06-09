/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service;

import com.company.models.user0;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {

    private static List<user0> users;

    public MyUserDetailsService() {
        users = new ArrayList<>();
        users.add(new user0("cem", "123", "USER"));
        users.add(new user0("ali", "123", "USER"));
        users.add(new user0("murat", "123", "USER"));
    }

    @Override
    //load user by its username from file,memory or database
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {

        for (user0 u : users) {
            if (string.equals(u.getUsername())) {
                User.UserBuilder builder = User.withDefaultPasswordEncoder();
                return builder.username(u.getUsername()).password(u.getPass()).roles(u.getAuthority()).build();
            }
        }

        throw new UsernameNotFoundException("kullanici yok veya yanlis sifre");

    }
}
