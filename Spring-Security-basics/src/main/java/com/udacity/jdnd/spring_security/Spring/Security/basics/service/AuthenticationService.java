package com.udacity.jdnd.spring_security.Spring.Security.basics.service;

import com.udacity.jdnd.spring_security.Spring.Security.basics.mapper.UserMapper;
import com.udacity.jdnd.spring_security.Spring.Security.basics.model.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Authentication Implementation:
 * it will implements a Spring interface called 'AuthenticationProvider';
 * it is used to validate if a user has logged in successfully;
 * it will use both User.class and UserMapper.interface;
 */

@Service
public class AuthenticationService implements AuthenticationProvider {

    private UserMapper userMapper;
    private HashService hashService;

    public AuthenticationService (UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    @Override
    public Authentication authenticate (Authentication authentication) throws AuthenticationException {

        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userMapper.getUser(username);
        if (user != null) {
            String encodedSalt = user.getSalt();
            String hashedPassword = hashService.getHashedValue(password, encodedSalt);
            if (user.getPassword().equals(hashedPassword)) { // because we saved the hashedValue of user's plain text password, we need to compare two hashed versions of passwords rather than their plain text form.
                return new UsernamePasswordAuthenticationToken(username, password, new ArrayList<>());
            }
        }
        return null;
    }

    @Override
    public boolean supports (Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
