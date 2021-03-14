package com.ymin.chatbot.service;

import com.ymin.chatbot.dto.User;
import com.ymin.chatbot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean checkUserById(String id){
        User user = userMapper.findUserById(id);
        return user != null;
    }

    public User findUserById(String id){
        return userMapper.findUserById(id);
    }

    public boolean insertUser(User user){
        return userMapper.insertUser(user.getId(), user.getBlockId());
    }

    public boolean insertUser(String id, String blockId){
        return userMapper.insertUser(id, blockId);
    }

    public boolean updateBlockId(String blockId, User user){
        return userMapper.updateBlockId(user.getId(), blockId);
    }

    public boolean updateBlockId(String blockId, String userId){
        return userMapper.updateBlockId(userId, blockId);
    }

    public boolean updateYear(String id, int year){
        return userMapper.updateYear(id, year);
    }

    public boolean updateAnswer(String id, String column, boolean answer){
        return  userMapper.updateAnswer(id, column, answer);
    }

    public boolean deleteUser(String id){
        return userMapper.deleteUser(id);
    }
}
