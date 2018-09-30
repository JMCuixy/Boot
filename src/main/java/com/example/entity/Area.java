package com.example.entity;

import java.util.List;

/**
 * Created by XiuYin.Cui on 2018/5/25.
 */
public class Area {

    /**
     * 值为0或1，0表示失败；1表示成功
     */
    private String status;

    /**
     * 返回状态说明，status为0时，info返回错误原因，否则返回“OK”。
     */
    private String info;


    /**
     * 返回状态说明，10000代表正确，详情参阅info状态表
     */
    private String infocode;

    /**
     *
     */
    private String count;

    /**
     * 建议结果列表
     */
    private Suggestion suggestion;

    /**
     * 行政区列表
     */
    private List<District> districts;

    public Area(){

    }

    public Area(String status, String info, String infocode, Suggestion suggestion, List<District> districts) {
        this.status = status;
        this.info = info;
        this.infocode = infocode;
        this.suggestion = suggestion;
        this.districts = districts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    @Override
    public String toString() {
        return "Area{" +
                "status='" + status + '\'' +
                ", info='" + info + '\'' +
                ", infocode='" + infocode + '\'' +
                ", suggestion=" + suggestion +
                ", districts=" + districts +
                '}';
    }
}
