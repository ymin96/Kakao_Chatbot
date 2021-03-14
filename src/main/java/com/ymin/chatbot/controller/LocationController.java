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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/main")
public class LocationController {

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/v1", method = {RequestMethod.GET,RequestMethod.POST}, headers = {"Accept=application/json"})
    public HashMap<String, Object> callAPI(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response){

        HashMap<String, Object> resultJson = new HashMap<>();

        try{
            ObjectMapper mapper = new ObjectMapper();
            String jsonInString = mapper.writeValueAsString(params);
            System.out.println(jsonInString);

            boolean check = userService.checkUserById("123");
            System.out.println(check);

            List<HashMap<String,Object>> outputs = new ArrayList<>();
            HashMap<String,Object> template = new HashMap<>();
            HashMap<String, Object> simpleText = new HashMap<>();
            HashMap<String, Object> text = new HashMap<>();

            text.put("text","코딩32 발화리턴입니다.");
            simpleText.put("simpleText",text);
            outputs.add(simpleText);

            template.put("outputs",outputs);

            resultJson.put("version","2.0");
            resultJson.put("template",template);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultJson;
    }

    @RequestMapping(value = "/welcome", method = {RequestMethod.GET,RequestMethod.POST}, headers = {"Accept=application/json"})
    public Map<String, String> welcome(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        Skill skill;
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(params);
        skill = mapper.readValue(jsonInString, Skill.class);

        String userId = skill.getUserRequest().getUser().getId();
        String blockId = skill.getIntent().getId();

        if(!userService.checkUserById(userId)){
            userService.insertUser(userId, blockId);
        }

        System.out.println(jsonInString);

        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("version", "2.0");

        return resultMap;
    }

    @RequestMapping(value = "/2014", method = {RequestMethod.GET,RequestMethod.POST}, headers = {"Accept=application/json"})
    public Map<String, String> welcome2014(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(params);
        Skill skill = mapper.readValue(jsonInString, Skill.class);

        String userId = skill.getUserRequest().getUser().getId();
        String blockId = skill.getIntent().getId();

        if(userService.checkUserById(userId)){
            userService.updateYear(userId, 2014);
        }

        userService.updateBlockId(blockId, userId);

        System.out.println(jsonInString);

        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("version", "2.0");

        return resultMap;
    }

    @RequestMapping(value = "/2021", method = {RequestMethod.GET,RequestMethod.POST}, headers = {"Accept=application/json"})
    public Map<String, String> welcome2021(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(params);
        Skill skill = mapper.readValue(jsonInString, Skill.class);

        String userId = skill.getUserRequest().getUser().getId();
        String blockId = skill.getIntent().getId();

        if(userService.checkUserById(userId)){
            userService.updateYear(userId, 2021);
        }

        userService.updateBlockId(blockId, userId);

        System.out.println(jsonInString);

        Map<String,String> resultMap = new HashMap<>();
        resultMap.put("version", "2.0");

        return resultMap;
    }

    @RequestMapping(value = "/move", method = {RequestMethod.GET, RequestMethod.POST}, headers = {"Accept=application/json"})
    public HashMap<String, Object> movement(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(params);
        Skill skill = mapper.readValue(jsonInString, Skill.class);

        String userId = skill.getUserRequest().getUser().getId();
        String blockId = skill.getIntent().getId();

        userService.updateBlockId(blockId, userId);

        System.out.println(jsonInString);

        SkillResponse skillResponse = new SkillResponse();
        return skillResponse.build();
    }

    @RequestMapping(value = "/fallback", method = {RequestMethod.GET, RequestMethod.POST}, headers = {"Accept=application/json"})
    public Map<String, Object> fallback(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(params);
        Skill skill = mapper.readValue(jsonInString, Skill.class);

        SkillResponse skillResponse = new SkillResponse();

        String userId = skill.getUserRequest().getUser().getId();

        // user가 없다면 바로 종료
        if(!userService.checkUserById(userId))
            return skillResponse.build();

        //userId 추출후 DB에서 User 검색
        User user = userService.findUserById(userId);

        //사용자 발화
        String utterance = skill.getUserRequest().getUtterance();
        utterance = utterance.toUpperCase();

        skillResponse.addQuickReplies("계속하자", user.getBlockId());
        if(user.getYear() == 2014){
            switch (user.getBlockId()){
                case SkillResponse.휴게실_2014:{
                    if(user.isQ1())
                        break;
                    if( utterance.equals("SOLO")){
                        userService.updateAnswer(userId, "q1", true);
                        return SkillResponse.휴게실_문제_성공_2014().build();
                    }
                    else
                        skillResponse.makeSimpleText("비밀번호를 잘못 입력한 듯 하다");
                    return skillResponse.build();
                }
                case SkillResponse.안무_연습실_피아노_2014:{
                    if(user.isQ2())
                        break;
                    if(utterance.equals("DZI")){    // 문제를 풀었을때
                        userService.updateAnswer(userId,"q2", true);
                        // 열쇠 획득
                        boolean itemCheck = itemService.findItem(userId, "열쇠");
                        if(!itemCheck){
                            Item item = new Item(userId, "열쇠", "https://postfiles.pstatic.net/MjAyMTAyMThfNjMg/MDAxNjEzNjU2Mzc1MDk3.BEtDzFnfsGZojiKy_8x5SIUFdsscZm8olzl6VvIgc-wg.-HgmEG5ZEXmrz5S9NqOYa3vJe6ZydDmDYHg3BRSycg8g.JPEG.arasarah/2014,_2021_%EC%95%88%EB%AC%B4_%EC%97%B0%EC%8A%B5%EC%8B%A4_%EC%97%B4%EC%87%A0.JPG?type=w773");
                            itemService.insertItem(item);
                        }
                        return SkillResponse.안무_연습실_피아노_성공_초기_2014().build();
                    }
                    else
                        skillResponse.makeSimpleText("알파벳이 쓰인 대로 건반을 눌러봤지만 아무 일도 일어나지 않았다. 이건 틀린 듯싶다.");
                    return skillResponse.build();
                }
                case SkillResponse.중간문_2014:{
                    if(user.isQ4())
                        break;
                    if(utterance.equals("231")){
                        userService.updateAnswer(userId, "q4", true);
                        return  SkillResponse.중간문_성공_2014().build();
                    }
                    else
                        skillResponse.makeSimpleText("비밀번호가 아닌 듯 하다.");
                    return skillResponse.build();
                }
                case SkillResponse.대표실_2014:{
                    if(user.isQ5())
                        break;
                    if(utterance.equals("0411")){
                        userService.updateAnswer(userId, "q5", true);
                        return SkillResponse.대표실_성공_2014().build();
                    }
                    else
                        skillResponse.makeSimpleText("비밀번호가 아닌 듯 하다.");
                    return skillResponse.build();
                }
                case SkillResponse.대표실_서류가방_2014:{
                    if(user.isQ6())
                        break;
                    if(utterance.equals("HIP")){
                        userService.updateAnswer(userId, "q6", true);
                        return SkillResponse.대표실_서류가방_성공_2014().build();
                    }
                    else
                        skillResponse.makeSimpleText("비밀번호가 아닌 듯 하다.");
                    return skillResponse.build();
                }
                case SkillResponse.대표실_컴퓨터_2014:{
                    if(user.isQ7())
                        break;
                    if(utterance.equals("BLUE")){
                        userService.updateAnswer(userId, "q7", true);
                        return SkillResponse.대표실_컴퓨터_성공_2014().build();
                    }
                    else
                        skillResponse.makeSimpleText("비밀번호가 아닌 듯 하다.");
                    return skillResponse.build();
                }
                case SkillResponse.정문_2014:{
                    if(user.isQ8())
                        break;
                    if(utterance.equals("719")){
                        userService.updateAnswer(userId, "q8", true);
                        return SkillResponse.정문_성공_2014().build();
                    }
                    else
                        skillResponse.makeSimpleText("비밀번호가 아닌 듯 하다.");
                    return skillResponse.build();
                }
            }
        }
        else if(user.getYear() == 2021){
            switch (user.getBlockId()){
                case SkillResponse.휴게실_2021:{
                    if (user.isQ1())
                        break;
                    if(utterance.equals("SOLO")){
                        userService.updateAnswer(userId, "q1", true);
                        return SkillResponse.휴게실_문제_성공_2021().build();
                    }
                    else
                        skillResponse.makeSimpleText("비밀번호를 잘못 입력한 듯 하다");
                    return skillResponse.build();
                }
                case SkillResponse.안무_연습실_피아노_2021:{
                    if(user.isQ2())
                        break;
                    if(utterance.equals("DZI")){    // 문제를 풀었을때
                        userService.updateAnswer(userId,"q2", true);
                        // 열쇠 획득
                        boolean itemCheck = itemService.findItem(userId, "열쇠");
                        if(!itemCheck){
                            Item item = new Item(userId, "열쇠", "https://postfiles.pstatic.net/MjAyMTAyMThfNjMg/MDAxNjEzNjU2Mzc1MDk3.BEtDzFnfsGZojiKy_8x5SIUFdsscZm8olzl6VvIgc-wg.-HgmEG5ZEXmrz5S9NqOYa3vJe6ZydDmDYHg3BRSycg8g.JPEG.arasarah/2014,_2021_%EC%95%88%EB%AC%B4_%EC%97%B0%EC%8A%B5%EC%8B%A4_%EC%97%B4%EC%87%A0.JPG?type=w773");
                            itemService.insertItem(item);
                        }
                        return SkillResponse.안무_연습실_피아노_성공_초기_2021().build();
                    }
                    else
                        skillResponse.makeSimpleText("알파벳이 쓰인 대로 건반을 눌러봤지만 아무 일도 일어나지 않았다. 이건 틀린 듯싶다.");
                    return skillResponse.build();
                }
                case SkillResponse.중간문_2021:{
                    if(user.isQ4())
                        break;
                    if(utterance.equals("752")){
                        userService.updateAnswer(userId, "q4", true);
                        return  SkillResponse.중간문_성공_2021().build();
                    }
                    else
                        skillResponse.makeSimpleText("비밀번호가 아닌 듯 하다.");
                    return skillResponse.build();
                }
                case SkillResponse.대표실_2021:{
                    if(user.isQ5())
                        break;
                    if(utterance.equals("0411")){
                        userService.updateAnswer(userId, "q5", true);
                        return SkillResponse.대표실_성공_2021().build();
                    }
                    else
                        skillResponse.makeSimpleText("비밀번호가 아닌 듯 하다.");
                    return skillResponse.build();
                }
                case SkillResponse.대표실_책상서랍_2021:{
                    if(user.isQ6())
                        break;
                    if(utterance.equals("AYA")){
                        userService.updateAnswer(userId, "q6", true);
                        return SkillResponse.대표실_책상서랍_성공_2021().build();
                    }
                    else
                        skillResponse.makeSimpleText("비밀번호가 아닌 듯 하다.");
                    return skillResponse.build();
                }
                case SkillResponse.대표실_컴퓨터_2021:{
                    if(user.isQ7())
                        break;
                    if(utterance.equals("믿지마")){
                        userService.updateAnswer(userId, "q7", true);
                        return SkillResponse.대표실_컴퓨터_성공_2021().build();
                    }
                    else
                        skillResponse.makeSimpleText("비밀번호가 아닌 듯 하다.");
                    return skillResponse.build();
                }
                case SkillResponse.정문_2021:{
                    if(user.isQ8())
                        break;
                    if(utterance.equals("912")){
                        userService.updateAnswer(userId, "q8", true);
                        return SkillResponse.정문_성공_2021().build();
                    }
                    else
                        skillResponse.makeSimpleText("비밀번호가 아닌 듯 하다.");
                    return skillResponse.build();
                }
            }
        }

        skillResponse.makeSimpleText("혼잣말을 해봤지만 아무일도 일어나지 않았다");
        return skillResponse.build();
    }

    @RequestMapping(value = "/continue", method = {RequestMethod.GET, RequestMethod.POST}, headers = {"Accept=application/json"})
    public Map<String, Object> continue_play(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(params);
        Skill skill = mapper.readValue(jsonInString, Skill.class);

        String userId = skill.getUserRequest().getUser().getId();

        User user = userService.findUserById(userId);

        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("잠시 멍 때렸나보다. 계속할까?");
        skillResponse.addQuickReplies("계속하자", user.getBlockId());

        return skillResponse.build();
    }

    @RequestMapping(value = "/init", method = {RequestMethod.GET, RequestMethod.POST}, headers = {"Accept=application/json"})
    public Map<String, Object> initGame(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(params);
        Skill skill = mapper.readValue(jsonInString, Skill.class);

        String userId = skill.getUserRequest().getUser().getId();

        if(userService.checkUserById(userId))
            userService.deleteUser(userId);

        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("모든 기록을 초기화 했습니다.");
        skillResponse.addQuickReplies("처음부터", SkillResponse.휴게실_시작);

        return skillResponse.build();
    }
}
