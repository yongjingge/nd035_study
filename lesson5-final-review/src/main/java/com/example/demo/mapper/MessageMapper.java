package com.example.demo.mapper;

import com.example.demo.model.ChatMessage;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {

    @Select("SELECT * FROM MESSAGES")
    List<ChatMessage> getChatMessages ();

    @Insert("INSERT INTO MESSAGES (username, messagetext) VALUES (#{username}, #{messagetext})")
    @Options(useGeneratedKeys = true, keyProperty = "messageId")
//    keyProperty = "messageId", which has to Exactly SAME with the field name of a ChatMessage Object
    int addMessage (ChatMessage chatMessage);
}
