package com.ymin.chatbot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Skill {

    private Intent intent;
    private UserRequest userRequest;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    static public class Intent{
       private String id, name;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Data
    static public class UserRequest{

        private User user;
        private String utterance;

    }
}
