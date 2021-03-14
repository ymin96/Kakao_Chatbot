package com.ymin.chatbot.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {

    private String id, blockId;
    private int year;
    private boolean q1;
    private boolean q2;
    private boolean q3;
    private boolean q4;
    private boolean q5;
    private boolean q6;
    private boolean q7;
    private boolean q8;


    public void setIsQ1(boolean q1) {
        this.q1 = q1;
    }

    public void setIsQ2(boolean q2) {
        this.q2 = q2;
    }

    public void setIsQ3(boolean q3) {
        this.q3 = q3;
    }

    public void setIsQ4(boolean q4) {
        this.q4 = q4;
    }

    public void setIsQ5(boolean q5) {
        this.q5 = q5;
    }

    public void setIsQ6(boolean q6) {
        this.q6 = q6;
    }

    public void setIsQ7(boolean q7) {
        this.q7 = q7;
    }

    public void setIsQ8(boolean q8) {
        this.q8 = q8;
    }

}
