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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/item")
public class ItemController {

    public static final String 열쇠_2014 = "600c2eb28025145479e3f36d";
    public static final String 쪽지1_2014 = "602ebc7fee18ba09cfbb47c5";
    public static final String 쪽지2_2014 = "602ebccca63d0458be5b3dcf";
    public static final String 쪽지3_2014 = "602ebd3389b96f0951cee0dd";
    public static final String 쪽지4_2014 = "602ebd5bc41f5f68aad83c80";

    public static final String 열쇠_2021 = "602ebdcc9438be6ba3c3c3a1";
    public static final String 쪽지1_2021 = "602ebdde3271251647528535";
    public static final String 쪽지2_2021 = "602ebe03c41f5f68aad83c83";
    public static final String 쪽지3_2021 = "602ebe166005b531982bf22d";
    public static final String 쪽지4_2021 = "602ebe319438be6ba3c3c3a5";

    @Autowired
    UserService userService;

    @Autowired
    ItemService itemService;


    @RequestMapping(value = "/2014/open", method = {RequestMethod.GET, RequestMethod.POST}, headers = {"Accept=application/json"})
    public HashMap<String, Object> bagOpen2014(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(params);
        Skill skill = mapper.readValue(jsonInString, Skill.class);

        String userId = skill.getUserRequest().getUser().getId();
        String blockId = skill.getIntent().getId();

        SkillResponse skillResponse = new SkillResponse();

        User user = userService.findUserById(userId);
        String lastBlockId = user.getBlockId();

        List<Item> itemList = itemService.getItemList(userId);

        //가방이 비어있다면 종료
        if (itemList.size() == 0) {
            skillResponse.makeSimpleText("가방이 비어있다.");
            skillResponse.addQuickReplies("계속하자", lastBlockId);
            return skillResponse.build();
        }

        skillResponse.addQuickReplies("가방닫기", lastBlockId);

        skillResponse.makeCarousel(itemList);
        if(user.getYear() == 2014){
            for (int i = 0; i < itemList.size(); i++) {
                Item item = itemList.get(i);
                switch (item.getName()) {
                    case "열쇠":
                        skillResponse.addQuickReplies("열쇠", 열쇠_2014);
                        break;
                    case "쪽지1":
                        skillResponse.addQuickReplies("쪽지1", 쪽지1_2014);
                        break;
                    case "쪽지2":
                        skillResponse.addQuickReplies("색상표", 쪽지2_2014);
                        break;
                    case "쪽지3":
                        skillResponse.addQuickReplies("쪽지2", 쪽지3_2014);
                        break;
                    case "쪽지4":
                        skillResponse.addQuickReplies("쪽지3", 쪽지4_2014);
                        break;
                }
            }
        }
        else if(user.getYear() == 2021){
            for (int i = 0; i < itemList.size(); i++) {
                Item item = itemList.get(i);
                switch (item.getName()) {
                    case "열쇠":
                        skillResponse.addQuickReplies("열쇠", 열쇠_2021);
                        break;
                    case "쪽지1":
                        skillResponse.addQuickReplies("쪽지1", 쪽지1_2021);
                        break;
                    case "쪽지2":
                        skillResponse.addQuickReplies("색상표", 쪽지2_2021);
                        break;
                    case "쪽지3":
                        skillResponse.addQuickReplies("쪽지2", 쪽지3_2021);
                        break;
                    case "쪽지4":
                        skillResponse.addQuickReplies("쪽지3", 쪽지4_2021);
                        break;
                }
            }
        }

        return skillResponse.build();
    }

    @RequestMapping(value = "/2014", method = {RequestMethod.GET, RequestMethod.POST}, headers = {"Accept=application/json"})
    public HashMap<String, Object> getItem2014(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(params);
        Skill skill = mapper.readValue(jsonInString, Skill.class);

        String userId = skill.getUserRequest().getUser().getId();
        String blockId = skill.getIntent().getId();

        SkillResponse skillResponse = new SkillResponse();

        User user = userService.findUserById(userId);

        userService.updateBlockId(blockId, userId);

        System.out.println(jsonInString);

        switch (blockId) {
            case SkillResponse.녹음실_책상_신문_스크랩_2014: {
                if (!itemService.findItem(userId, "쪽지1")) {
                    itemService.insertItem(new Item(user.getId(), "쪽지1", "https://postfiles.pstatic.net/MjAyMTAzMTNfMjk0/MDAxNjE1NjQ1OTE1OTMx.hbFQLE0ZgkKWlm3KtxwlyxHbCsq-KdTNLFzzixWd2nUg.WAnGyKbEEFBEkNvKJVzvCKADQKalELWp_ukw_WiyLB4g.JPEG.arasarah/9D13F2A8-D4EF-49EE-922E-92F96608291B.jpeg?type=w773"));
                    return SkillResponse.녹음실_책상_신문_스크랩_초기_2014().build();
                }
                return SkillResponse.녹음실_책상_신문_스크랩_후기_2014().build();
            }
            case SkillResponse.녹음실_녹음부스_2014: {
                if (!itemService.findItem(user.getId(), "쪽지2")) {
                    itemService.insertItem(new Item(user.getId(), "쪽지2", "https://postfiles.pstatic.net/MjAyMTAyMThfMTQy/MDAxNjEzNjU2NjIwMTU2.KzuevKXVDOZzVRZpmVFYCfL80StPUO7K5NNA0HOV-2Yg.52ds02bq2WqtR1NMYq_gAVlGYsJmna2_fsc9sTOTBEgg.JPEG.arasarah/2014,_2021_%EB%85%B9%EC%9D%8C%EC%8B%A4_%EC%AA%BD%EC%A7%80.JPG?type=w773"));
                    return SkillResponse.녹음실_녹음부스_초기_2014().build();
                }
                return SkillResponse.녹음실_녹음부스_후기_2014().build();
            }
            case SkillResponse.대표실_달력_2014: {
                if (!itemService.findItem(user.getId(), "쪽지4")) {
                    itemService.insertItem(new Item(user.getId(), "쪽지4", "https://postfiles.pstatic.net/MjAyMTAzMTNfMTQ2/MDAxNjE1NjQ1OTE1OTkx.32Emoa_LGRnnwWwPJL4NdEGu8stdCRgVjpxpF3-Fjogg.2ct0VYZSmPWFrN6s0kHTjuIWPd20ZIcAxPRAd51zVkQg.JPEG.arasarah/2D4B67E8-216A-4D36-A8EA-B219F9C1E12B.jpeg?type=w773"));
                    return SkillResponse.대표실_달력_초기_2014().build();
                }
                return SkillResponse.대표실_달력_후기_2014().build();
            }
        }

        return skillResponse.build();
    }

    @RequestMapping(value = "/2021", method = {RequestMethod.GET, RequestMethod.POST}, headers = {"Accept=application/json"})
    public HashMap<String, Object> getItem2021(@RequestBody Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = mapper.writeValueAsString(params);
        Skill skill = mapper.readValue(jsonInString, Skill.class);

        String userId = skill.getUserRequest().getUser().getId();
        String blockId = skill.getIntent().getId();

        SkillResponse skillResponse = new SkillResponse();

        User user = userService.findUserById(userId);

        userService.updateBlockId(blockId, userId);

        System.out.println(jsonInString);

        switch (blockId) {
            case SkillResponse.녹음실_책상_신문_스크랩_2021: {
                if (!itemService.findItem(userId, "쪽지1")) {
                    itemService.insertItem(new Item(user.getId(), "쪽지1", "https://postfiles.pstatic.net/MjAyMTAzMTNfMTA4/MDAxNjE1NjQ1OTE1OTg0.tLevUsULa8zJ_JENfzyN4VZNlghuRxCCbaPx22fH2KUg.ie9p2rBOF7gMZu6k39jrSbuuYb-ImwX7_Ww0VYsM6Okg.JPEG.arasarah/8E3CA69B-7246-4F4A-B6FC-7AC7D252037B.jpeg?type=w773"));
                    return SkillResponse.녹음실_책상_신문_스크랩_초기_2021().build();
                }
                return SkillResponse.녹음실_책상_신문_스크랩_후기_2021().build();
            }
            case SkillResponse.녹음실_녹음부스_2021: {
                if (!itemService.findItem(user.getId(), "쪽지2")) {
                    itemService.insertItem(new Item(user.getId(), "쪽지2", "https://postfiles.pstatic.net/MjAyMTAyMThfMTQy/MDAxNjEzNjU2NjIwMTU2.KzuevKXVDOZzVRZpmVFYCfL80StPUO7K5NNA0HOV-2Yg.52ds02bq2WqtR1NMYq_gAVlGYsJmna2_fsc9sTOTBEgg.JPEG.arasarah/2014,_2021_%EB%85%B9%EC%9D%8C%EC%8B%A4_%EC%AA%BD%EC%A7%80.JPG?type=w773"));
                    return SkillResponse.녹음실_녹음부스_초기_2021().build();
                }
                return SkillResponse.녹음실_녹음부스_후기_2021().build();
            }
            case SkillResponse.대표실_달력_2021: {
                if (!itemService.findItem(user.getId(), "쪽지4")) {
                    itemService.insertItem(new Item(user.getId(), "쪽지4", "https://postfiles.pstatic.net/MjAyMTAzMTNfMzMg/MDAxNjE1NjQ1OTE2NDY0.nI_53wvkXbOHVMMdspwPEshMOd_tK0I-yfJOfOTGoacg.eprA1HKd7Yvd2VaVd1rYzsZKeEq7MdxtsYu8eMbRTMgg.JPEG.arasarah/C77BA9DE-DFC8-46EE-B8D0-945B0CAFF196.jpeg?type=w773"));
                    return SkillResponse.대표실_달력_초기_2021().build();
                }
                return SkillResponse.대표실_달력_후기_2021().build();
            }
        }


        return skillResponse.build();
    }
}
