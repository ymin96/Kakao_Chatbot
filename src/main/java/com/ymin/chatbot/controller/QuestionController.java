package com.ymin.chatbot.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ymin.chatbot.dto.Item;
import com.ymin.chatbot.dto.Skill;
import com.ymin.chatbot.dto.SkillResponse;
import com.ymin.chatbot.dto.User;
import com.ymin.chatbot.service.ItemService;
import com.ymin.chatbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;


    @RequestMapping(value = "/2014", method = {RequestMethod.GET, RequestMethod.POST}, headers = {"Accept=application/json"})
    public HashMap<String, Object> question2014(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(params);
        Skill skill = mapper.readValue(jsonInString, Skill.class);

        String userId = skill.getUserRequest().getUser().getId();
        String blockId = skill.getIntent().getId();
        User user = userService.findUserById(userId);

        userService.updateBlockId(blockId, userId);

        SkillResponse skillResponse = new SkillResponse();

        System.out.println(jsonInString);

        switch(blockId){
            case SkillResponse.휴게실_2014: // 휴게실 입장
                return (user.isQ1()? SkillResponse.휴게실_문제_성공_2014().build() : SkillResponse.휴게실_문제_실패_2014().build());
            case SkillResponse.안무_연습실_피아노_2014: { // 안무 연습실 입장
                if(user.isQ2())
                    return (itemService.findItem(userId, "열쇠") ? SkillResponse.안무_연습실_피아노_성공_후기_2014().build() : SkillResponse.안무_연습실_피아노_성공_초기_2014().build());
                else
                    return SkillResponse.안무_연습실_피아노_실패_2014().build();
            }
            case SkillResponse.녹음실_2014: //녹음실 입장
                if(user.isQ3())
                    return SkillResponse.녹음실_성공_2014().build();

                if(itemService.findItem(user.getId(), "열쇠")){
                    userService.updateAnswer(user.getId(), "q3", true);
                    return SkillResponse.녹음실_성공_2014().build();
                }

                return SkillResponse.녹음실_실패_2014().build();
            case SkillResponse.중간문_2014: // 중간문 입장
                return(user.isQ4() ? SkillResponse.중간문_성공_2014().build() : SkillResponse.중간문_실패_2014().build());
            case SkillResponse.대표실_2014: // 대표실 입장
                return (user.isQ5() ? SkillResponse.대표실_성공_2014().build() : SkillResponse.대표실_실패_2014().build());
            case SkillResponse.대표실_서류가방_2014: // 서류가방
                return  SkillResponse.대표실_서류가방_실패_2014().build();
            case SkillResponse.대표실_컴퓨터_2014: // 컴퓨터
                if(!itemService.findItem(user.getId(), "쪽지2")){
                    itemService.insertItem(new Item(user.getId(), "쪽지2", "https://postfiles.pstatic.net/MjAyMTAzMTNfMjc1/MDAxNjE1NjQ1OTE1OTk5.riMCRadc2zopnZpA2hcBh8IKfCQEbWflUcy-iPKJIW8g.e9T4PHu6W121s7ryg8L4zsWwWcR7Eh32UaBA5hOxPBwg.JPEG.arasarah/9692B73A-AD9C-45AE-AD30-AFE74EC252F1.jpeg?type=w773"));
                    return SkillResponse.대표실_컴퓨터_실패_2014_초기().build();
                }
                return (user.isQ7() ? SkillResponse.대표실_컴퓨터_성공_2014().build() : SkillResponse.대표실_컴퓨터_실패_2014().build());
            case SkillResponse.정문_2014: // 정문
                return (user.isQ8() ? SkillResponse.정문_성공_2014().build() : SkillResponse.정문_실패_2014().build());
        }

        return skillResponse.build();
    }

    @RequestMapping(value = "/2021", method = {RequestMethod.GET, RequestMethod.POST}, headers = {"Accept=application/json"})
    public HashMap<String, Object> question2021(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(params);
        Skill skill = mapper.readValue(jsonInString, Skill.class);

        String userId = skill.getUserRequest().getUser().getId();
        String blockId = skill.getIntent().getId();
        User user = userService.findUserById(userId);

        userService.updateBlockId(blockId, userId);

        SkillResponse skillResponse = new SkillResponse();

        System.out.println(jsonInString);

        switch(blockId){
            case SkillResponse.휴게실_2021: // 휴게실 입장
                return (user.isQ1()? SkillResponse.휴게실_문제_성공_2021().build() : SkillResponse.휴게실_문제_실패_2021().build());
            case SkillResponse.안무_연습실_피아노_2021: { // 안무 연습실 입장
                if(user.isQ2())
                    return (itemService.findItem(userId, "열쇠") ? SkillResponse.안무_연습실_피아노_성공_후기_2021().build() : SkillResponse.안무_연습실_피아노_성공_초기_2021().build());
                else
                    return SkillResponse.안무_연습실_피아노_실패_2021().build();
            }
            case SkillResponse.녹음실_2021: //녹음실 입장
                if(user.isQ3())
                    return SkillResponse.녹음실_성공_2021().build();

                if(itemService.findItem(user.getId(), "열쇠")){
                    userService.updateAnswer(user.getId(), "q3", true);
                    return SkillResponse.녹음실_성공_2021().build();
                }
                return SkillResponse.녹음실_실패_2021().build();
            case SkillResponse.중간문_2021: // 중간문 입장
                return(user.isQ4() ? SkillResponse.중간문_성공_2021().build() : SkillResponse.중간문_실패_2021().build());
            case SkillResponse.대표실_2021: // 대표실 입장
                return (user.isQ5() ? SkillResponse.대표실_성공_2021().build() : SkillResponse.대표실_실패_2021().build());
            case SkillResponse.대표실_책상서랍_2021: // 책상서랍
                return  SkillResponse.대표실_책상서랍_실패_2021().build();
            case SkillResponse.대표실_컴퓨터_2021: // 컴퓨터
                if(!itemService.findItem(user.getId(), "쪽지2")){
                    itemService.insertItem(new Item(user.getId(), "쪽지2", "https://postfiles.pstatic.net/MjAyMTAzMTNfMjA5/MDAxNjE1NjQ1OTE2NTE4.-0UpzAYJrzBKEC-7qbN8KCPKtCMdjRE-_nYGoeOuDkQg.VLZAPfZLRqW057bez-VDa2zVbIGhJxY0HQ9qor1T7q0g.JPEG.arasarah/16E0203C-569F-475C-919C-74A84B062393.jpeg?type=w773"));
                    return SkillResponse.대표실_컴퓨터_실패_2021_초기().build();
                }
                return (user.isQ7() ? SkillResponse.대표실_컴퓨터_성공_2021().build() : SkillResponse.대표실_컴퓨터_실패_2021().build());
            case SkillResponse.정문_2021: // 정문
                return (user.isQ8() ? SkillResponse.정문_성공_2021().build() : SkillResponse.정문_실패_2021().build());
        }

        return skillResponse.build();
    }
}
