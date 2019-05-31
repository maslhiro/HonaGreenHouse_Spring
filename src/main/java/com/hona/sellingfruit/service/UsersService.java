package com.hona.sellingfruit.service;

import com.hona.sellingfruit.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsersService implements UserDetailsService {
    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails user = usersRepository.findByTenDangNhap(s);

        if (user == null) {
            throw new UsernameNotFoundException("User not authorized.");
        }
        System.out.println("Found User: " + user);
        return  user;
    }

}
