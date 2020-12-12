package com.udacity.jdnd.spring_security.Spring.Security.basics.service;

/**
 * Hashing Implementation:
 * how to hash user passwords in the database
 * convert password into a hashed value before saving it
 * first we need UserMapper to check if the username exists;
 * then insert this new user with its hashed information.
 *
 * import UserMapper: to check if the user's username already exists in the database;
 * import User;
 * Need HashService.class to use its getHashedValue() method;
 */

import com.udacity.jdnd.spring_security.Spring.Security.basics.mapper.UserMapper;
import com.udacity.jdnd.spring_security.Spring.Security.basics.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class UserService {

    private final UserMapper userMapper;
    private final HashService hashService;

    public UserService (UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    public boolean isUsernameAvailable (String username) {
        return userMapper.getUser(username) == null;
    }

    public int createUser (User user) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        User newUser = new User(null, user.getUsername(), encodedSalt, hashedPassword, user.getFirstName(), user.getLastName());
        return userMapper.insert(newUser);
    }

    public User getUser (String username) {
        return userMapper.getUser(username);
    }

}
