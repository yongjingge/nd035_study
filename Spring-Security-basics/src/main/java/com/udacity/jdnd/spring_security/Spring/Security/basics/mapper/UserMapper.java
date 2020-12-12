package com.udacity.jdnd.spring_security.Spring.Security.basics.mapper;
/**
 * Mapping from java class fields (User.class) to SQL table columns (database)
 */

import com.udacity.jdnd.spring_security.Spring.Security.basics.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM USERS WHERE username = #{username}")
    User getUser (String username);

    @Insert("INSERT INTO USERS (username, salt, password, firstName, lastName) VALUES (#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    Integer insert (User user);
}
