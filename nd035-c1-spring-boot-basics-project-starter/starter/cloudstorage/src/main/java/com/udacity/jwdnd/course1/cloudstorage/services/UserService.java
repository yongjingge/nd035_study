package com.udacity.jwdnd.course1.cloudstorage.services;

import com.udacity.jwdnd.course1.cloudstorage.mapper.UserMapper;
import com.udacity.jwdnd.course1.cloudstorage.model.User;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

/**
 * performing Hashing Implementation and creating new User
 */

@Service
public class UserService {

    private final UserMapper userMapper;
    private final HashService hashService;

    public UserService(UserMapper userMapper, HashService hashService) {
        this.userMapper = userMapper;
        this.hashService = hashService;
    }

    public boolean isUsernameValid (String username) {
        return userMapper.getUserByUsername(username) == null;
    }

    public Integer createUser (User user) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        String encodedSalt = Base64.getEncoder().encodeToString(salt);
        String hashedPassword = hashService.getHashedValue(user.getPassword(), encodedSalt);
        User hashedNewUser = new User(null, user.getUsername(), encodedSalt, hashedPassword, user.getFirstname(), user.getLastname());
        return userMapper.addUser(hashedNewUser); // will return user.userid;
    }

    public User getUserByUsername (String username) {
        return userMapper.getUserByUsername(username);
    }

    public User getUserByUserid (Integer userid) {
        return userMapper.getUserByUserid(userid);
    }
}
