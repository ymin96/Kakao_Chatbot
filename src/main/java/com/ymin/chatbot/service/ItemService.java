package com.ymin.chatbot.service;

import com.ymin.chatbot.dto.Item;
import com.ymin.chatbot.mapper.ItemMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemService {

    @Autowired
    ItemMapper itemMapper;

    public boolean findItem(String userId, String name){
        Item item = itemMapper.findItem(userId, name);

        return (item != null);
    }

    public boolean insertItem(Item item){
        return itemMapper.insertItem(item.getUserId(), item.getName(), item.getUrl());
    }

    public List<Item> getItemList(String userId){
        return itemMapper.getItemList(userId);
    }

    public boolean deleteItem(String userId, String name){
        return itemMapper.deleteItem(userId, name);
    }
}
