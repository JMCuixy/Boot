package com.example.entity;

import java.util.List;

/**
 * Created by XiuYin.Cui on 2018/5/28.
 */
public class District {

    /**
     * 城市编码 (没有值得时候返回 [] ,有一个值得时候 返回字符串"010" ,有两个值得时候 返回["010","011"])
     */
    private Object citycode;

    /**
     * 区域编码
     */
    private String adcode;

    /**
     * 行政区名称
     */
    private String name;

    /**
     * 行政区边界坐标点
     */
    private String polyline;

    /**
     * 城市中心点
     */
    private String center;

    /**
     * 行政区划级别
     */
    private String level;

    /**
     * districts
     */
    private List<District> districts;

    private District() {

    }

    public District(Object citycode, String adcode, String name, String polyline, String center, String level, List<District> districts) {
        this.citycode = citycode;
        this.adcode = adcode;
        this.name = name;
        this.polyline = polyline;
        this.center = center;
        this.level = level;
        this.districts = districts;
    }

    public Object getCitycode() {
        return citycode;
    }

    public void setCitycode(Object citycode) {
        this.citycode = citycode;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPolyline() {
        return polyline;
    }

    public void setPolyline(String polyline) {
        this.polyline = polyline;
    }

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    @Override
    public String toString() {
        return "District{" +
                "citycode=" + citycode +
                ", adcode='" + adcode + '\'' +
                ", name='" + name + '\'' +
                ", polyline='" + polyline + '\'' +
                ", center='" + center + '\'' +
                ", level='" + level + '\'' +
                ", districts=" + districts +
                '}';
    }
}
