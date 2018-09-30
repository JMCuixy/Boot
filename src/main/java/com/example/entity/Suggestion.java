package com.example.entity;

import java.util.List;

/**
 * Created by XiuYin.Cui on 2018/5/25.
 */
public class Suggestion {

    /**
     * 建议关键字列表
     */
    private List<String> keywords;


    /**
     * 建议城市列表
     */
    private List<String> cites;


    public Suggestion(){

    }

    public Suggestion(List<String> keywords, List<String> cites) {
        this.keywords = keywords;
        this.cites = cites;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public List<String> getCites() {
        return cites;
    }

    public void setCites(List<String> cites) {
        this.cites = cites;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "keywords=" + keywords +
                ", cites=" + cites +
                '}';
    }
}
