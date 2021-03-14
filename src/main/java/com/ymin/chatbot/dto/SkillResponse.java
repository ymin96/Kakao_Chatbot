package com.ymin.chatbot.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class SkillResponse {

    private HashMap<String, Object> resultJSON;
    private List<HashMap<String, Object>> outputs, quickReplies;

    public static final String 휴게실_시작 = "60034edbfcd6b51386d99307";
    public static final String 휴게실_2014 = "60295a63e178b46e3ec90e8e";
    public static final String 휴게실_주변_2014 = "60295a5de178b46e3ec90e8c";
    public static final String 안무_연습실_2014 = "6003509d63230e0e69fdb435";
    public static final String 안무_연습실_피아노_2014 = "600350c883ef3d5f1492be14";
    public static final String 화장실_2014 = "600351d9fcd6b51386d9930e";
    public static final String 녹음실_2014 = "6003519c63230e0e69fdb439";
    public static final String 녹음실_책상_2014 = "600c1e83e0c5156fec2f93a6";
    public static final String 녹음실_책상_신문_스크랩_2014 = "602a59855894d401cdfc849b";
    public static final String 녹음실_책상_신문_스크랩_사이_2014 = "602df2e1b5e6784b1e1f5b49";
    public static final String 녹음실_컴퓨터_2014 = "600c1f308025145479e3f347";
    public static final String 녹음실_녹음부스_2014 = "600c1fd0be6daf0e45f11d3f";
    public static final String 사무실_복도_사진_2014 = "602df925829c941e3c6b7b1f";
    public static final String 회의실_2014 = "600c2cb1e0c5156fec2f93b4";
    public static final String 중간문_2014 = "600351f54cabe927f0650b26";
    public static final String 대표실_2014 = "600c27bfbe6daf0e45f11d4e";
    public static final String 대표실_서류가방_2014 = "600c286a75fb626d937f8f62";
    public static final String 대표실_컴퓨터_2014 = "600c2afcbe6daf0e45f11d52";
    public static final String 대표실_달력_2014 = "600c2be027384a6d147f6d45";
    public static final String 정문_2014 = "600c2e2a6896a854af7b5d06";
    public static final String 엔딩_용선_2014 = "602ebfd989b96f0951cee0df";
    public static final String 엔딩_혜진_2014 = "602ebfea162d281487788d48";

    public static final String 휴게실_2021 = "602ea9fb89b96f0951cedffd";
    public static final String 휴게실_주변_2021 = "602ea99b3271251647528476";
    public static final String 안무_연습실_2021 = "602eac8aa63d0458be5b3cf4";
    public static final String 안무_연습실_피아노_2021 = "602eacb089b96f0951cee007";
    public static final String 화장실_2021 = "602eaec79438be6ba3c3c390";
    public static final String 녹음실_2021 = "602eadb889b96f0951cee00f";
    public static final String 녹음실_책상_2021 = "602eadf1327125164752848b";
    public static final String 녹음실_책상_신문_스크랩_2021 = "602eae0989b96f0951cee012";
    public static final String 녹음실_책상_신문_스크랩_사이_2021 = "602eae356005b531982bf21c";
    public static final String 녹음실_컴퓨터_2021 = "602eae8c6005b531982bf21e";
    public static final String 녹음실_녹음부스_2021 = "602eae9d8a2949583bf1e595";
    public static final String 사무실_복도_사진_2021 = "602eaff9327125164752848f";
    public static final String 회의실_2021 = "602eb31da63d0458be5b3d89";
    public static final String 중간문_2021 = "602eaf166005b531982bf221";
    public static final String 대표실_2021 = "602eb01d8a2949583bf1e59a";
    public static final String 대표실_책상서랍_2021 = "602eb0668a2949583bf1e59c";
    public static final String 대표실_컴퓨터_2021 = "602eb1758a2949583bf1e59f";
    public static final String 대표실_달력_2021 = "602eb2edc41f5f68aad83c70";
    public static final String 정문_2021 = "602eb39eee18ba09cfbb4731";
    public static final String 엔딩_문별_2021 = "602ebff66005b531982bf231";
    public static final String 엔딩_휘인_2021 = "602ebfff3271251647528538";
    public static final String 대표실_컴퓨터_파일2 = "602eb296423b2951811f2d72";


    public SkillResponse(){
        resultJSON = new HashMap<>();
        outputs = new ArrayList<>();
        quickReplies = new ArrayList<>();
    }

    public void init(){
        resultJSON = new HashMap<>();
        outputs = new ArrayList<>();
    }

    public void makeSimpleText(String msg){

        HashMap<String, Object> simpleText = new HashMap<>();
        HashMap<String, Object> text = new HashMap<>();

        text.put("text",msg);
        simpleText.put("simpleText", text);

        outputs.add(simpleText);
    }

    public void makeSimpleImage(String imageUrl, String msg){
        HashMap<String, Object> simpleImage = new HashMap<>();
        HashMap<String, Object> image = new HashMap<>();

        image.put("imageUrl", imageUrl);
        image.put("altText", msg);
        simpleImage.put("simpleImage", image);

        outputs.add(simpleImage);
    }

    public void addQuickReplies(String msg, String blockId){
        HashMap<String, Object> quickReply = new HashMap<>();
        quickReply.put("action", "block");
        quickReply.put("label", msg);
        quickReply.put("messageText", msg);
        quickReply.put("blockId", blockId);

        quickReplies.add(quickReply);
    }

    public void makeCarousel(List<Item> itemList){
        HashMap<String, Object> carousel = new HashMap<>();
        HashMap<String, Object> carouselInfo = new HashMap<>();
        List<HashMap<String, Object>> items = new ArrayList<>();
        HashMap<String, Object> item;

        for(int i=0 ;i< itemList.size(); i++){
            HashMap<String, Object> imageUrl = new HashMap<>();
            item = new HashMap<>();
            item.put("title", itemList.get(i).getName());
            imageUrl.put("imageUrl", itemList.get(i).getUrl());
            item.put("thumbnail", imageUrl);
            items.add(item);
        }

        carouselInfo.put("type", "basicCard");
        carouselInfo.put("items", items);
        carousel.put("carousel", carouselInfo);

        outputs.add(carousel);
    }

    public HashMap<String, Object> build(){
        resultJSON = new HashMap<>();
        HashMap<String, Object> template = new HashMap<>();
        template.put("outputs", outputs);
        template.put("quickReplies", quickReplies);
        resultJSON.put("template", template);
        resultJSON.put("version", "2.0");

        return resultJSON;
    }

    public static SkillResponse 휴게실_문제_성공_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMThfNCAg/MDAxNjEzNjU2MjYzMzU3.aSbBEumdJDLzu95yYtGGO6clezCzVvboHw4NHZCK_F8g.Av7_ghIExYAmELYivAYfmnVMfwNi-5-ufOuUU_3BIpcg.JPEG.arasarah/2014,_2021_%EC%97%B0%EC%8A%B5%EC%8B%A4_%EB%B3%B5%EB%8F%84.JPG?type=w773","이미지 에러");
        skillResponse.makeSimpleText("[연습실 복도]\n" +
                "\n" +
                "길게 뻗어 있는 복도로 나왔다.\n" +
                "\n" +
                "어디로 갈까?");
        skillResponse.addQuickReplies("녹음실", 녹음실_2014);
        skillResponse.addQuickReplies("안무 연습실", 안무_연습실_2014);
        skillResponse.addQuickReplies("화장실", 화장실_2014);
        skillResponse.addQuickReplies("사무실 복도", 중간문_2014);
        skillResponse.addQuickReplies("휴게실", 휴게실_주변_2014);
        return skillResponse;
    }

    public static SkillResponse 휴게실_문제_실패_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("문이 잠겨 있다. 문을 열기 위해선 알파벳 비밀번호가 필요하다. \n" +
                "문에 붙어 있는 알 수 없는 메시지가 비밀번호 힌트라고 들었는데...");
        skillResponse.makeSimpleImage("http://postfiles.pstatic.net/MjAyMTAyMThfMTU2/MDAxNjEzNjU2MjQ2NjMy.O7y1g1IwMvnlQD6DqXLdPmAfTHt5FvdD4HFFhwUXnAcg.ZvBsT7oNoPbONDT4i5j0y2QQHkYzbq-Ji0Z6pPYFrj8g.JPEG.arasarah/2014,_2021_%ED%9C%B4%EA%B2%8C%EC%8B%A4_%EB%AC%B8%EC%A0%9C.JPG?type=w773","이미지 오류");
        skillResponse.addQuickReplies("돌아가자", 휴게실_주변_2014);
        return skillResponse;
    }

    public static SkillResponse 안무_연습실_피아노_성공_초기_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("알파벳이 쓰인 대로 건반을 누르자 세 개의 음이 들리고 듣기 좋지 않은 소리가 연습실을 채웠다. 힘을 잃고 아래로 꺼져버린 건반 하나를 들춰 내니 열쇠가 하나 들어 있다.\n" +
                "무슨 열쇠인지는 모르겠지만 우선 챙기도록 하자.");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMThfNjMg/MDAxNjEzNjU2Mzc1MDk3.BEtDzFnfsGZojiKy_8x5SIUFdsscZm8olzl6VvIgc-wg.-HgmEG5ZEXmrz5S9NqOYa3vJe6ZydDmDYHg3BRSycg8g.JPEG.arasarah/2014,_2021_%EC%95%88%EB%AC%B4_%EC%97%B0%EC%8A%B5%EC%8B%A4_%EC%97%B4%EC%87%A0.JPG?type=w773", "이미지 오류");
        skillResponse.addQuickReplies("돌아가자", 안무_연습실_2014);
        return skillResponse;
    }

    public static SkillResponse 안무_연습실_피아노_성공_후기_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("이미 필요한 정보를 얻은거같다.");
        skillResponse.addQuickReplies("돌아가자", 안무_연습실_2014);
        return skillResponse;
    }

    public static SkillResponse 안무_연습실_피아노_실패_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("닫혀 있던 피아노 뚜껑을 열었다. 그러자 닫혀있던 뚜껑 안에 붙어 있는 이상한 쪽지.\n" +
                "그리고 건반 위엔 규칙을 알 수 없는 알파벳과 숫자가 쓰여 있다.\n" +
                "여기에 단서가 있을 것 같은데...");
        skillResponse.makeSimpleImage("http://postfiles.pstatic.net/MjAyMTAyMThfMTA1/MDAxNjEzNjU2MzEyODcw.DcdCGdW6oUEsSJWyPv76HhpKYQUVCxv8jbV7J3kb30Ig.S_vWMbkT4l8l2zqaQRMkeAQIdwTSoFBosgQ34P1PqTog.JPEG.arasarah/2014,_2021_%EC%95%88%EB%AC%B4_%EC%97%B0%EC%8A%B5%EC%8B%A4_%EB%AC%B8%EC%A0%9C.JPG?type=w773","이미지 오류");
        skillResponse.addQuickReplies("돌아가자", 안무_연습실_2014);
        return skillResponse;
    }

    public static SkillResponse 녹음실_실패_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("녹음실로 들어가는 문이 잠겨있다. 들어가기 위해선 열쇠가 필요하다. ");
        skillResponse.addQuickReplies("돌아가자", 휴게실_2014);
        return skillResponse;
    }

    public static SkillResponse 녹음실_성공_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMThfMTk1/MDAxNjEzNjU2NTY2MjQ5.fykBCqIkQZgQGN6__HTho6jJ9RpQqgXy5Tu8TatLDBsg.JkaMBAEan-4_tYy2nfXekymxEyzHFIqwnd0ZMNBPYpAg.JPEG.arasarah/2014,_2021_%EB%85%B9%EC%9D%8C%EC%8B%A4.JPG?type=w773", "이미지 에러");
        skillResponse.makeSimpleText("[녹음실]\n" +
                "\n" +
                "가방에 있는 열쇠를 사용하여 녹음실로 들어왔다..\n" +
                "오늘까지도 녹음이 있었던 녹음실엔 사람의 흔적이 곳곳에 남아 있었다.\n" +
                "\n" +
                "어디를 살펴볼까?");
        skillResponse.addQuickReplies("책상", 녹음실_책상_2014);
        skillResponse.addQuickReplies("컴퓨터", 녹음실_컴퓨터_2014);
        skillResponse.addQuickReplies("녹음 부스", 녹음실_녹음부스_2014);
        skillResponse.addQuickReplies("나가자", 휴게실_2014);
        return skillResponse;
    }

    public static SkillResponse 중간문_실패_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("사무실로 넘어가는 중간문이 잠겨있다.\n" +
                "비밀번호를 쳐야 하는데 무엇일까.");
        skillResponse.makeSimpleImage("http://postfiles.pstatic.net/MjAyMTAyMThfMjgy/MDAxNjEzNjU2ODExNzkz.W5WnAg67NIJoXgrmr1TplQdHdX8HjYFuUbgqYhJ64B4g.pzL-seiqjRn453MUsQ8fsAGQw-LotqIeafTEdtYdo2kg.JPEG.arasarah/2014_%EC%A4%91%EA%B0%84%EB%AC%B8_%EB%AC%B8%EC%A0%9C.JPG?type=w773","이미지 오류");
        skillResponse.addQuickReplies("돌아가자", 휴게실_2014);
        return skillResponse;
    }

    public static SkillResponse 중간문_성공_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMThfODYg/MDAxNjEzNjU2NzIwNzU4.uCJMdjiQxZv1AXxViQRylBr4YeHrLBaiU5MoaSIiCdIg.8Ee4hCyW87Pl8YLJrLPvXZdYpE31H2bAezVvMP-3Iz4g.JPEG.arasarah/2014_%EC%82%AC%EB%AC%B4%EC%8B%A4_%EB%B3%B5%EB%8F%84.JPG?type=w773","이미지 에러");
        skillResponse.makeSimpleText("주로 직원들이 이용하는 사무실 복도는 연습실과는 다른 분위기를 풍기고 있었다. 복도 벽면엔 우리 회사를 대표하는 사람들의 사진이 걸려 있었다. 대표실에서 찍은 대표의 사진, 대표 듀오 엔젤의 사진, 그리고 회사 워크샵을 갔을 때 대표와 연습생들이 함께 찍은 사진까지.\n" +
                "\n" +
                "깜깜한 복도를 걸으며 다음 행선지를 고민했다. 해가 뜨기 전, 어서 숨겨진 비밀을 찾아야 하니까.\n\n어디로 갈까? ");
        skillResponse.addQuickReplies("사진을 확인한다", 사무실_복도_사진_2014 );
        skillResponse.addQuickReplies("희의실", 회의실_2014);
        skillResponse.addQuickReplies("대표실", 대표실_2014);
        skillResponse.addQuickReplies("정문", 정문_2014);
        skillResponse.addQuickReplies("연습실 복도", 휴게실_2014);
        return skillResponse;
    }

    public static SkillResponse 대표실_실패_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("대표실로 들어 가기 위해선 네자리의 비밀번호를 쳐야한다. ");
        skillResponse.addQuickReplies("돌아가자", 중간문_2014);
        return skillResponse;
    }

    public static SkillResponse 대표실_성공_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMThfMjM1/MDAxNjEzNjU2ODYwMzE2.kcuaiLbz8ky-kkpwUpu2Ww9ucyWGzTN2YNjfclaKyd8g.Ng97oSzvjVusV7loMRXxwXJXO5QApnpKSHa-BY07mZAg.JPEG.arasarah/2014_%EB%8C%80%ED%91%9C%EC%8B%A4.JPG?type=w773","이미지 에러");
        skillResponse.makeSimpleText("[대표실]\n" +
                "\n" +
                "대표실의 문이 열렸다. 깔끔하게 정돈된 방 안에서는 의심의 향이 가장 강하게 흘렀다.\n" +
                "무엇을 살펴볼까?");
        skillResponse.addQuickReplies("서류가방", 대표실_서류가방_2014);
        skillResponse.addQuickReplies("컴퓨터", 대표실_컴퓨터_2014);
        skillResponse.addQuickReplies("달력", 대표실_달력_2014);
        skillResponse.addQuickReplies("나가자", 중간문_2014);
        return skillResponse;
    }

    public static SkillResponse 대표실_서류가방_실패_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("서류 가방 안쪽에 오래된 휴대폰과 쪽지가 함께 있었다.휴대폰은  몇 년은 지난 구형 휴대폰이었다. 가장 의심스러운 물건의 전원을 켜자 잠금 화면이 화면을 밝혔다. 휴대폰의 잠금을 풀기 위해선 비밀번호가 필요하다.");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAzMTRfMjEy/MDAxNjE1NjY5MzgyOTM5.mtfLTYOiFPRC793fvMWvAtsDwvB0I-QjsWztVrO4kgIg.ZK2bX8fDT1LKdS9ay8cQjiYZ9IoRn2qynG39IooTD2gg.PNG.arasarah/IMG_0368.png?type=w773","이미지 오류");
        skillResponse.addQuickReplies("돌아가기", 대표실_2014);
        return skillResponse;
    }

    public static SkillResponse 대표실_서류가방_성공_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("잠금 화면이 풀리자 녹음실 컴퓨터에서 봤던 여자 중 한 명의 얼굴로 된 배경화면이 떴다.\n\n" +
                "통화목록은 2013년 1월 15일에서 끊겨 있다. 통화목록의 대부분을 채우는 건 ‘문이사님’. 문자메시지 함으로 들어가니 문자 역시 가장 마지막 기록이 ‘문이사님’이다.\n\n" +
                "[가장 완벽한 걸그룹을 만들 거야. 선희 너는 내가 만들고 싶은 가장 완벽한 걸그룹 멤버가 될 거야. 어서 와. 기다리고 있어. -2013.01.15 문이사님]\n\n" +
                "가장 마지막 문자를 확인 했다. ");
        skillResponse.addQuickReplies("돌아가자", 대표실_2014);
        return skillResponse;
    }

    public static SkillResponse 대표실_컴퓨터_실패_2014_초기(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAzMTNfMjc1/MDAxNjE1NjQ1OTE1OTk5.riMCRadc2zopnZpA2hcBh8IKfCQEbWflUcy-iPKJIW8g.e9T4PHu6W121s7ryg8L4zsWwWcR7Eh32UaBA5hOxPBwg.JPEG.arasarah/9692B73A-AD9C-45AE-AD30-AFE74EC252F1.jpeg?type=w773","이미지 오류");
        skillResponse.makeSimpleText("컴퓨터를 확인하려 모니터를 살피니 쪽지가 하나 붙어있다. 어떤 힌트로 쓰일지 모르니 우선 가방에 챙기자. \n" +
                "\n" +
                "컴퓨터를 확인하려니 잠금이 걸려있다. 비밀번호를 쳐야 하는데 뭘까? 아래에 보이는 힌트를 이용하면 답이 나올 것 같다. ");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMTlfMTcz/MDAxNjEzNjc2MjAzNzk4.NRaphmvNY1aTDqxzGrTHZLH6wOuf-m5Kt1MWEBibtX4g.T_pGcib3nDBUcxgKto4UgK4FQVT7tTUxIGHG0p3CR6kg.JPEG.arasarah/2014_%EB%8C%80%ED%91%9C%EC%8B%A4_%EC%BB%B4%ED%93%A8%ED%84%B0_%EB%AC%B8%EC%A0%9C.JPG?type=w773","이미지 오류");
        skillResponse.addQuickReplies("돌아가자", 대표실_2014);
        return skillResponse;
    }

    public static SkillResponse 대표실_컴퓨터_실패_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("컴퓨터를 확인하려니 잠금이 걸려있다. 비밀번호를 쳐야 하는데 뭘까? 아래에 보이는 힌트를 이용하면 답이 나올 것 같다. ");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMTlfMTcz/MDAxNjEzNjc2MjAzNzk4.NRaphmvNY1aTDqxzGrTHZLH6wOuf-m5Kt1MWEBibtX4g.T_pGcib3nDBUcxgKto4UgK4FQVT7tTUxIGHG0p3CR6kg.JPEG.arasarah/2014_%EB%8C%80%ED%91%9C%EC%8B%A4_%EC%BB%B4%ED%93%A8%ED%84%B0_%EB%AC%B8%EC%A0%9C.JPG?type=w773","이미지 오류");
        skillResponse.addQuickReplies("돌아가자", 대표실_2014);
        return skillResponse;
    }

    public static SkillResponse 대표실_컴퓨터_성공_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("바탕화면에는 회사와 관련된 온갖 파일들이 있었다. 그 중 혼자만 간격이 크게 떨어져 있는 수상한 파일 하나가 보였다. \n'Top star project file'이란 제목의 한글 파일. 파일을 확인해보자. ");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMTlfMjUy/MDAxNjEzNjc2MzE0NTMy.aud9ri4hsE08nkIXVqQBKDxp8LqBtudTq0TTTyK2pSEg.OwbUHJ_n9sI3kt10iPzobJ6lDT6K1oabcWDMy8FWryog.JPEG.arasarah/2014,_2021_%EB%8C%80%ED%91%9C%EC%8B%A4_%EC%BB%B4%ED%93%A8%ED%84%B0_%ED%94%84%EB%A1%9C%EC%A0%9D%ED%8A%B8_%ED%8C%8C%EC%9D%BC.JPG?type=w773","이미지 오류");
        skillResponse.makeSimpleText("이제 이 회사에 숨겨 놓은 비밀을 모두 찾았다. 더 늦기 전에 서둘러 밖으로 나가자. ");
        skillResponse.addQuickReplies("돌아가자", 대표실_2014);
        return skillResponse;
    }

    public static SkillResponse 정문_실패_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("문이 잠겨있다. 나가기 위해선 올바른 비밀번호가 필요하다. ");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAzMDNfMTQ0/MDAxNjE0NzMwOTMyNzEz.HArK05sstuQY9hEBGIrefC8K58xEuSJMCgSSabBoqvsg.xrDV2Ob-fxEStorKFpDUnXgx5eXzaxVAjUQSzeZvvYcg.JPEG.arasarah/B1CA9656-FD64-48ED-A73B-B47010DC2B20.jpeg?type=w773","이미지 에러");
        skillResponse.addQuickReplies("돌아가자", 중간문_2014);
        return skillResponse;
    }

    public static SkillResponse 정문_성공_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("밖으로 나왔다. 이제 서둘러 회사에서 알아낸 진실을 세상에 밝혀야 한다. 이 진실들을 누구에게 먼저 얘기할까. ");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMjBfMjE4/MDAxNjEzODEzMDU2NzY0.Uyr6MGzyLLPjjJZJhaQPgTiwh438mhqTrg1JxC6ggjwg.YNKCpBCNIs43mWzyuI4m6LCSRUhpU-SB5wBUyeqDhEog.JPEG.arasarah/8162318F-1F00-498A-A3FB-248FECB93B72.jpeg?type=w773","이미지 오류");
        skillResponse.addQuickReplies("동료", 엔딩_용선_2014);
        skillResponse.addQuickReplies("대표", 엔딩_혜진_2014);
        return skillResponse;
    }

    public static SkillResponse 녹음실_책상_신문_스크랩_초기_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAzMTRfMTcz/MDAxNjE1NjY5NDczNjY4.FuHASAamFHJYnfGdnbJJEFJJFGUrPrfgLf8Z2qxbZQgg.wo6jEhLXV150pWqt_tl-PUHWOBkyO4ZJ0unRGj5m2Dgg.JPEG.arasarah/2014_%EB%85%B9%EC%9D%8C%EC%8B%A4_%EC%8B%A0%EB%AC%B8_%EC%8A%A4%ED%81%AC%EB%9E%A9.JPG?type=w773","이미지 오류");
        skillResponse.makeSimpleText("왜 이런 기사들을 모아 둔 거지? 어딘가 찜찜한 기분을 느끼며 파일을 덮었다.  ");
        skillResponse.addQuickReplies("돌아가자", 녹음실_책상_신문_스크랩_사이_2014);
        return skillResponse;
    }

    public static SkillResponse 녹음실_책상_신문_스크랩_후기_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAzMTRfMTcz/MDAxNjE1NjY5NDczNjY4.FuHASAamFHJYnfGdnbJJEFJJFGUrPrfgLf8Z2qxbZQgg.wo6jEhLXV150pWqt_tl-PUHWOBkyO4ZJ0unRGj5m2Dgg.JPEG.arasarah/2014_%EB%85%B9%EC%9D%8C%EC%8B%A4_%EC%8B%A0%EB%AC%B8_%EC%8A%A4%ED%81%AC%EB%9E%A9.JPG?type=w773","이미지 오류");
        skillResponse.makeSimpleText("왜 이런 기사들을 모아 둔 거지? 어딘가 찜찜한 기분을 느끼며 파일을 덮었다.  ");
        skillResponse.addQuickReplies("돌아가자", 녹음실_2014);
        return skillResponse;
    }

    public static SkillResponse 녹음실_녹음부스_초기_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("부스 안에 들어가자 더욱더 고요한 공기가 감싼다. 부스 안 악보대에 작은 쪽지가 있다. 이건 뭐지?");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMThfMTQy/MDAxNjEzNjU2NjIwMTU2.KzuevKXVDOZzVRZpmVFYCfL80StPUO7K5NNA0HOV-2Yg.52ds02bq2WqtR1NMYq_gAVlGYsJmna2_fsc9sTOTBEgg.JPEG.arasarah/2014,_2021_%EB%85%B9%EC%9D%8C%EC%8B%A4_%EC%AA%BD%EC%A7%80.JPG?type=w773","이미지 오류");
        skillResponse.makeSimpleText("우선 챙기자.");
        skillResponse.addQuickReplies("돌아가자", 녹음실_2014);
        return skillResponse;
    }

    public static SkillResponse 녹음실_녹음부스_후기_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("부스 안에 들어가자 더욱 고요한 공기가 감싼다. 다른 특별한 건 없어 보인다. ");
        skillResponse.addQuickReplies("돌아가자", 녹음실_2014);
        return skillResponse;
    }

    public static SkillResponse 대표실_달력_초기_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("특별한 건 없어 보인다. \n" +
                "\n" +
                "어?");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAzMTNfMTQ2/MDAxNjE1NjQ1OTE1OTkx.32Emoa_LGRnnwWwPJL4NdEGu8stdCRgVjpxpF3-Fjogg.2ct0VYZSmPWFrN6s0kHTjuIWPd20ZIcAxPRAd51zVkQg.JPEG.arasarah/2D4B67E8-216A-4D36-A8EA-B219F9C1E12B.jpeg?type=w773","이미지 오류");
        skillResponse.makeSimpleText("지나치려던 찰나 달력에서 쪽지 하나가 바닥으로 떨어졌다. 어디에 쓰일지 모르니 우선 챙기자. ");
        skillResponse.addQuickReplies("돌아가자", 대표실_2014);
        return skillResponse;
    }

    public static SkillResponse 대표실_달력_후기_2014(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("이 곳에서 얻을 수 있는 정보는 더이상 없는 것 같다.");
        skillResponse.addQuickReplies("돌아가기", 대표실_2014);
        return skillResponse;
    }


    public static SkillResponse 휴게실_문제_성공_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMThfNCAg/MDAxNjEzNjU2MjYzMzU3.aSbBEumdJDLzu95yYtGGO6clezCzVvboHw4NHZCK_F8g.Av7_ghIExYAmELYivAYfmnVMfwNi-5-ufOuUU_3BIpcg.JPEG.arasarah/2014,_2021_%EC%97%B0%EC%8A%B5%EC%8B%A4_%EB%B3%B5%EB%8F%84.JPG?type=w773","이미지 에러");
        skillResponse.makeSimpleText("[연습실 복도]\n" +
                "\n" +
                "길게 뻗어 있는 복도로 나왔다.\n" +
                "\n" +
                "어디로 갈까?");
        skillResponse.addQuickReplies("녹음실", 녹음실_2021);
        skillResponse.addQuickReplies("안무 연습실", 안무_연습실_2021);
        skillResponse.addQuickReplies("화장실", 화장실_2021);
        skillResponse.addQuickReplies("사무실 복도", 중간문_2021);
        skillResponse.addQuickReplies("휴게실", 휴게실_주변_2021);
        return skillResponse;
    }

    public static SkillResponse 휴게실_문제_실패_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("문이 잠겨 있다. 문을 열기 위해선 알파벳 비밀번호가 필요하다. \n" +
                "문에 붙어 있는 알 수 없는 메시지가 비밀번호 힌트라고 들었는데...");
        skillResponse.makeSimpleImage("http://postfiles.pstatic.net/MjAyMTAyMThfMTU2/MDAxNjEzNjU2MjQ2NjMy.O7y1g1IwMvnlQD6DqXLdPmAfTHt5FvdD4HFFhwUXnAcg.ZvBsT7oNoPbONDT4i5j0y2QQHkYzbq-Ji0Z6pPYFrj8g.JPEG.arasarah/2014,_2021_%ED%9C%B4%EA%B2%8C%EC%8B%A4_%EB%AC%B8%EC%A0%9C.JPG?type=w773","이미지 오류");
        skillResponse.addQuickReplies("돌아가자", 휴게실_주변_2021);
        return skillResponse;
    }

    public static SkillResponse 안무_연습실_피아노_성공_초기_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("알파벳이 쓰인 대로 건반을 누르자 세 개의 음이 들리고 듣기 좋지 않은 소리가 연습실을 채웠다. 힘을 잃고 아래로 꺼져버린 건반 하나를 들춰 내니 열쇠가 하나 들어 있다.\n" +
                "무슨 열쇠인지는 모르겠지만 우선 챙기도록 하자.");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMThfNjMg/MDAxNjEzNjU2Mzc1MDk3.BEtDzFnfsGZojiKy_8x5SIUFdsscZm8olzl6VvIgc-wg.-HgmEG5ZEXmrz5S9NqOYa3vJe6ZydDmDYHg3BRSycg8g.JPEG.arasarah/2014,_2021_%EC%95%88%EB%AC%B4_%EC%97%B0%EC%8A%B5%EC%8B%A4_%EC%97%B4%EC%87%A0.JPG?type=w773", "이미지 오류");
        skillResponse.addQuickReplies("돌아가자", 안무_연습실_2021);
        return skillResponse;
    }

    public static SkillResponse 안무_연습실_피아노_성공_후기_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("이미 필요한 정보를 얻은거같다.");
        skillResponse.addQuickReplies("돌아가자", 안무_연습실_2021);
        return skillResponse;
    }

    public static SkillResponse 안무_연습실_피아노_실패_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("닫혀 있던 피아노 뚜껑을 열었다. 그러자 닫혀있던 뚜껑 안에 붙어 있는 이상한 쪽지.\n" +
                "그리고 건반 위엔 규칙을 알 수 없는 알파벳과 숫자가 쓰여 있다.\n" +
                "여기에 단서가 있을 것 같은데...");
        skillResponse.makeSimpleImage("http://postfiles.pstatic.net/MjAyMTAyMThfMTA1/MDAxNjEzNjU2MzEyODcw.DcdCGdW6oUEsSJWyPv76HhpKYQUVCxv8jbV7J3kb30Ig.S_vWMbkT4l8l2zqaQRMkeAQIdwTSoFBosgQ34P1PqTog.JPEG.arasarah/2014,_2021_%EC%95%88%EB%AC%B4_%EC%97%B0%EC%8A%B5%EC%8B%A4_%EB%AC%B8%EC%A0%9C.JPG?type=w773","이미지 오류");
        skillResponse.addQuickReplies("돌아가자", 안무_연습실_2021);
        return skillResponse;
    }

    public static SkillResponse 녹음실_실패_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("녹음실로 들어가는 문이 잠겨있다. 들어가기 위해선 열쇠가 필요하다. ");
        skillResponse.addQuickReplies("돌아가자", 휴게실_2021);
        return skillResponse;
    }

    public static SkillResponse 녹음실_성공_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMThfMTk1/MDAxNjEzNjU2NTY2MjQ5.fykBCqIkQZgQGN6__HTho6jJ9RpQqgXy5Tu8TatLDBsg.JkaMBAEan-4_tYy2nfXekymxEyzHFIqwnd0ZMNBPYpAg.JPEG.arasarah/2014,_2021_%EB%85%B9%EC%9D%8C%EC%8B%A4.JPG?type=w773", "이미지 에러");
        skillResponse.makeSimpleText("[녹음실]\n" +
                "\n" +
                "가방에 있는 열쇠를 사용하여 녹음실로 들어왔다..\n" +
                "오늘까지도 녹음이 있었던 녹음실엔 사람의 흔적이 곳곳에 남아 있었다.\n" +
                "\n" +
                "어디를 살펴볼까?");
        skillResponse.addQuickReplies("책상", 녹음실_책상_2021);
        skillResponse.addQuickReplies("컴퓨터", 녹음실_컴퓨터_2021);
        skillResponse.addQuickReplies("녹음 부스", 녹음실_녹음부스_2021);
        skillResponse.addQuickReplies("나가자", 휴게실_2021);
        return skillResponse;
    }

    public static SkillResponse 중간문_실패_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("사무실로 넘어가는 중간문이 잠겨있다.\n" +
                "비밀번호를 쳐야 하는데 무엇일까.");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMThfMTM4/MDAxNjEzNjU2ODM0NjUz.0hXW2wqMDaKHdsnj2D-vx7fBqVQ6dNJJmxvwzVVA6zcg.THFfM6s0BmZ0TN40lttUf6DGEY9_OiF-_a5dRWbuH6og.JPEG.arasarah/2021_%EC%A4%91%EA%B0%84%EB%AC%B8_%EB%AC%B8%EC%A0%9C.JPG?type=w773","이미지 오류");
        skillResponse.addQuickReplies("돌아가자", 휴게실_2021);
        return skillResponse;
    }

    public static SkillResponse 중간문_성공_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMThfMjIz/MDAxNjEzNjU2NzMzNjU4.AguAqQImVuZiP1qFDZ5VsNG6HGYQueR3mEjagixr664g.e58Uf5koL6Nlw5szoiXTTPuJDuBRRAtYKccj9uktK3Ug.JPEG.arasarah/2021_%EC%82%AC%EB%AC%B4%EC%8B%A4_%EB%B3%B5%EB%8F%84.JPG?type=w773","이미지 에러");
        skillResponse.makeSimpleText("주로 직원들이 이용하는 사무실 복도는 연습실과는 다른 분위기를 풍기고 있었다. 복도 벽면엔 우리 회사를 대표하는 사람들의 사진이 걸려 있었다. 대표실에서 찍은 대표의 사진, 대표 듀오 엔젤의 사진, 그리고 회사 워크샵을 갔을 때 대표와 연습생들이 함께 찍은 사진까지.\n" +
                "\n" +
                "깜깜한 복도를 걸으며 다음 행선지를 고민했다. 해가 뜨기 전, 어서 숨겨진 비밀을 찾아야 하니까. \n\n어디로 갈까?");
        skillResponse.addQuickReplies("사진을 확인한다", 사무실_복도_사진_2021 );
        skillResponse.addQuickReplies("희의실", 회의실_2021);
        skillResponse.addQuickReplies("대표실", 대표실_2021);
        skillResponse.addQuickReplies("정문", 정문_2021);
        skillResponse.addQuickReplies("연습실 복도", 휴게실_2021);
        return skillResponse;
    }

    public static SkillResponse 대표실_실패_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("대표실로 들어 가기 위해선 네자리의 비밀번호를 쳐야한다. ");
        skillResponse.addQuickReplies("돌아가자", 중간문_2021);
        return skillResponse;
    }

    public static SkillResponse 대표실_성공_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMThfMjAw/MDAxNjEzNjU2ODY3NjY5.tjv_9Fi4T7Xmgewr4JVvuldnCIIdQVCjlGajxv-jd9og.lePIsvA-3kyDg2GdcATSKQhQvnyY_0BGVuaOEzeN__4g.JPEG.arasarah/2021_%EB%8C%80%ED%91%9C%EC%8B%A4.JPG?type=w773","이미지 에러");
        skillResponse.makeSimpleText("[대표실]\n" +
                "\n" +
                "대표실의 문이 열렸다. 깔끔하게 정돈된 방 안에서는 의심의 향이 가장 강하게 흘렀다.\n" +
                "무엇을 살펴볼까?");
        skillResponse.addQuickReplies("책상서랍", 대표실_책상서랍_2021);
        skillResponse.addQuickReplies("컴퓨터", 대표실_컴퓨터_2021);
        skillResponse.addQuickReplies("달력", 대표실_달력_2021);
        skillResponse.addQuickReplies("나가자", 중간문_2021);
        return skillResponse;
    }

    public static SkillResponse 대표실_책상서랍_실패_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("책상 서랍을 열었다. 수상할 것 없는 사무 용품들과 각종 서류 뭉치들이 지저분하게 들어 있었다. 이리저리 뒤져보니 서랍 가장 안쪽에 오래된 휴대폰과 쪽지가 함께 있었다.휴대폰은  몇 년은 지난 구형 휴대폰이었다. 가장 의심스러운 물건의 전원을 켜자 잠금 화면이 화면을 밝혔다. 휴대폰의 잠금을 풀기 위해선 비밀번호가 필요하다.");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMTlfMjE5/MDAxNjEzNjc2MjE5NzUx.W8lbBzueKOeYcGvxUcCEWTKKQzw08HTBCCfpmqVD2N0g.UYZuGAuph0KNW2YzehyieuG0lF6vMNYdFniGKI-3xsQg.JPEG.arasarah/2021_%EB%8C%80%ED%91%9C%EC%8B%A4_%ED%9C%B4%EB%8C%80%ED%8F%B0_%EB%AC%B8%EC%A0%9C.JPG?type=w773","이미지 오류");
        skillResponse.addQuickReplies("돌아가자", 대표실_2021);
        return skillResponse;
    }

    public static SkillResponse 대표실_책상서랍_성공_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("잠금 화면이 풀리자 용선의 사진으로 된 배경화면이 뜬다.\n" +
                "통화목록을 들어가니 2014년 2월 21일에서 끊겨 있다. 마지막 통화자의 이름은 ‘월성 문별이 대표님’.  그 아래로 월성 안혜진, 월성 정휘인, 엄마, 언니로 된 통화 내역들이 보인다.");
        skillResponse.addQuickReplies("돌아가자", 대표실_2021);
        return skillResponse;
    }

    public static SkillResponse 대표실_컴퓨터_실패_2021_초기(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAzMTNfMjA5/MDAxNjE1NjQ1OTE2NTE4.-0UpzAYJrzBKEC-7qbN8KCPKtCMdjRE-_nYGoeOuDkQg.VLZAPfZLRqW057bez-VDa2zVbIGhJxY0HQ9qor1T7q0g.JPEG.arasarah/16E0203C-569F-475C-919C-74A84B062393.jpeg?type=w773","이미지 오류");
        skillResponse.makeSimpleText("컴퓨터를 확인하려 모니터를 살피니 쪽지가 하나 붙어있다. 어떤 힌트로 쓰일지 모르니 우선 가방에 챙기자. \n---------------------\n꺼져 있는 컴퓨터를 켰다. 딱히 비밀번호는 걸어 놓지 않은 것 같다. 나는 온갖 폴더들을 하나씩 뒤지기 시작했다.  10여분 가량의 사투 끝에 수상한 폴더 하나를 발견했다. ‘진실’이라는 폴더를 누르니 비밀번호를 입력하라고 한다. ");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMTlfNjMg/MDAxNjEzNjc2MjM0OTQ2.dCypSmYsHl8loX9JfJzJKt5GuWpJvi2AjlcagzX9BoMg.qjvF-H39ql2LUK1J957db7jiAUdbEGnjHJ8NZAY96Xcg.JPEG.arasarah/2021_%EB%8C%80%ED%91%9C%EC%8B%A4_%EC%BB%B4%ED%93%A8%ED%84%B0_%EB%AC%B8%EC%A0%9C.JPG?type=w773","이미지 오류");
        skillResponse.addQuickReplies("돌아가자", 대표실_2021);
        return skillResponse;
    }

    public static SkillResponse 대표실_컴퓨터_실패_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("꺼져 있는 컴퓨터를 켰다. 딱히 비밀번호는 걸어 놓지 않은 것 같다. 나는 온갖 폴더들을 하나씩 뒤지기 시작했다.  10여분 가량의 사투 끝에 수상한 폴더 하나를 발견했다. ‘진실’이라는 폴더를 누르니 비밀번호를 입력하라고 한다. ");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMTlfNjMg/MDAxNjEzNjc2MjM0OTQ2.dCypSmYsHl8loX9JfJzJKt5GuWpJvi2AjlcagzX9BoMg.qjvF-H39ql2LUK1J957db7jiAUdbEGnjHJ8NZAY96Xcg.JPEG.arasarah/2021_%EB%8C%80%ED%91%9C%EC%8B%A4_%EC%BB%B4%ED%93%A8%ED%84%B0_%EB%AC%B8%EC%A0%9C.JPG?type=w773","이미지 오류");
        skillResponse.addQuickReplies("돌아가자", 대표실_2014);
        return skillResponse;
    }

    public static SkillResponse 대표실_컴퓨터_성공_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("컴퓨터 안의 ‘진실’이라는 폴더에 '믿지마' 비밀번호를 입력했더니\n" +
                "폴더가 열렸다! 폴더 안에는 문별이 대표의 사진 한 장이 들어 있었다. 사진의 이름은 Double Click. 사진을 더블 클릭하니 사진으로 숨겨진 또 다른 폴더로 들어가진다.");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMTlfMTk5/MDAxNjEzNjc2Mjc0NjY4.obFUEKpcoKzG5nmrASYC_24VGAR60A5LMiEOlzpMDdQg.IMSENqjG9L7kv350TLL69d10OAr7EmypvluzGdznJ-4g.JPEG.arasarah/2021_%EB%8C%80%ED%91%9C%EC%8B%A4_%EC%BB%B4%ED%93%A8%ED%84%B0_%ED%8C%8C%EC%9D%BC.JPG?type=w773","이미지 오류");
        skillResponse.addQuickReplies("Double Click", 대표실_컴퓨터_파일2);
        return skillResponse;
    }

    public static SkillResponse 정문_실패_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("문이 잠겨있다. 나가기 위해선 올바른 비밀번호가 필요하다. ");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAzMDNfMTQ0/MDAxNjE0NzMwOTMyNzEz.HArK05sstuQY9hEBGIrefC8K58xEuSJMCgSSabBoqvsg.xrDV2Ob-fxEStorKFpDUnXgx5eXzaxVAjUQSzeZvvYcg.JPEG.arasarah/B1CA9656-FD64-48ED-A73B-B47010DC2B20.jpeg?type=w773","이미지 에러");
        skillResponse.addQuickReplies("돌아가자", 중간문_2021);
        return skillResponse;
    }

    public static SkillResponse 정문_성공_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("밖으로 나왔다. 이제 이 진실을 어떻게 할지 내 손에 달려 있다.");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMjBfMjE4/MDAxNjEzODEzMDU2NzY0.Uyr6MGzyLLPjjJZJhaQPgTiwh438mhqTrg1JxC6ggjwg.YNKCpBCNIs43mWzyuI4m6LCSRUhpU-SB5wBUyeqDhEog.JPEG.arasarah/8162318F-1F00-498A-A3FB-248FECB93B72.jpeg?type=w773","이미지 오류");
        skillResponse.addQuickReplies("진실을 밝힌다", 엔딩_휘인_2021);
        skillResponse.addQuickReplies("진실을 은폐한다", 엔딩_문별_2021);
        return skillResponse;
    }

    public static SkillResponse 녹음실_책상_신문_스크랩_초기_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAzMTRfMTYw/MDAxNjE1NjY5NDEwNDg0.RdROClPoQeiLZ4miVZSR9YpfUumL4eNoQ9Ujwpdg4_0g.1VRgdRsSLSgFDF5n5LADV7-o3Fvc4ILDSI6juJs0SRog.JPEG.arasarah/2021_%EC%8B%A0%EB%AC%B8%EC%8A%A4%ED%81%AC%EB%9E%A9.jpg?type=w773","이미지 오류");
        skillResponse.makeSimpleText("왜 이런 기사들을 모아 둔 거지? 어딘가 찜찜한 기분을 느끼며 파일을 덮었다.  ");
        skillResponse.addQuickReplies("돌아가자", 녹음실_책상_신문_스크랩_사이_2021);
        return skillResponse;
    }

    public static SkillResponse 녹음실_책상_신문_스크랩_후기_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAzMTRfMTYw/MDAxNjE1NjY5NDEwNDg0.RdROClPoQeiLZ4miVZSR9YpfUumL4eNoQ9Ujwpdg4_0g.1VRgdRsSLSgFDF5n5LADV7-o3Fvc4ILDSI6juJs0SRog.JPEG.arasarah/2021_%EC%8B%A0%EB%AC%B8%EC%8A%A4%ED%81%AC%EB%9E%A9.jpg?type=w773","이미지 오류");
        skillResponse.makeSimpleText("왜 이런 기사들을 모아 둔 거지? 어딘가 찜찜한 기분을 느끼며 파일을 덮었다.  ");
        skillResponse.addQuickReplies("돌아가자", 녹음실_2021);
        return skillResponse;
    }

    public static SkillResponse 녹음실_녹음부스_초기_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("부스 안에 들어가자 더욱더 고요한 공기가 감싼다. 부스 안 악보대에 작은 쪽지가 있다. 이건 뭐지?");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAyMThfMTQy/MDAxNjEzNjU2NjIwMTU2.KzuevKXVDOZzVRZpmVFYCfL80StPUO7K5NNA0HOV-2Yg.52ds02bq2WqtR1NMYq_gAVlGYsJmna2_fsc9sTOTBEgg.JPEG.arasarah/2014,_2021_%EB%85%B9%EC%9D%8C%EC%8B%A4_%EC%AA%BD%EC%A7%80.JPG?type=w773","이미지 오류");
        skillResponse.makeSimpleText("우선 챙기자.");
        skillResponse.addQuickReplies("돌아가자", 녹음실_2021);
        return skillResponse;
    }

    public static SkillResponse 녹음실_녹음부스_후기_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("부스 안에 들어가자 더욱 고요한 공기가 감싼다. 다른 특별한 건 없어 보인다. ");
        skillResponse.addQuickReplies("돌아가자", 녹음실_2021);
        return skillResponse;
    }

    public static SkillResponse 대표실_달력_초기_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("특별한 건 없어 보인다. \n" +
                "\n" +
                "어?");
        skillResponse.makeSimpleImage("https://postfiles.pstatic.net/MjAyMTAzMTNfMzMg/MDAxNjE1NjQ1OTE2NDY0.nI_53wvkXbOHVMMdspwPEshMOd_tK0I-yfJOfOTGoacg.eprA1HKd7Yvd2VaVd1rYzsZKeEq7MdxtsYu8eMbRTMgg.JPEG.arasarah/C77BA9DE-DFC8-46EE-B8D0-945B0CAFF196.jpeg?type=w773","이미지 오류");
        skillResponse.makeSimpleText("지나치려던 찰나 달력에서 쪽지 하나가 바닥으로 떨어졌다. 어디에 쓰일지 모르니 우선 챙기자. ");
        skillResponse.addQuickReplies("돌아가자", 대표실_2021);
        return skillResponse;
    }

    public static SkillResponse 대표실_달력_후기_2021(){
        SkillResponse skillResponse = new SkillResponse();
        skillResponse.makeSimpleText("이 곳에서 얻을 수 있는 정보는 더이상 없는 것 같다.");
        skillResponse.addQuickReplies("돌아가기", 대표실_2021);
        return skillResponse;
    }
}
