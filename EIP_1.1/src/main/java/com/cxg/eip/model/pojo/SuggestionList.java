package com.cxg.eip.model.pojo;

import org.springframework.stereotype.Component;

@Component
public class SuggestionList {
    private Integer id;
    private String suggestContent;
    private String deficiency;
    private String effect;
    private String userName;
    private String sHead;

    Integer sCount;

    public SuggestionList() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSuggestContent() {
        return suggestContent;
    }

    public void setSuggestContent(String suggestContent) {
        this.suggestContent = suggestContent;
    }

    public String getDeficiency() {
        return deficiency;
    }

    public void setDeficiency(String deficiency) {
        this.deficiency = deficiency;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getsHead() {
        return sHead;
    }

    public void setsHead(String sHead) {
        this.sHead = sHead;
    }

    public Integer getsCount() {
        return sCount;
    }

    public void setsCount(Integer sCount) {
        this.sCount = sCount;
    }
}
