package com.ymin.chatbot.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Item {

    private String userId,name, url;

    public Item(String userId,String name,String url){
        this.userId = userId;
        this.name = name;
        this.url = url;
    }

}
