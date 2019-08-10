package com.kexie.Course.pojo;

import javax.persistence.*;

//声明这是一个实体类
@Entity
@Table(name = "coursetable")
public class courseItem {
    //主键以及自增类型
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Time;

    //星期一
    private String Monday;

    //星期二
    private String Tuesday;

    //星期三
    private String Wednesday;

    //星期四
    private String Thursday;

    //星期五
    private String Friday;

    //星期六
    private String Saturday;

    //星期天
    private String Sunday;


    public Integer getTime() {
        return Time;
    }

    public void setTime(Integer time) {
        Time = time;
    }

    public String getMonday() {
        return Monday;
    }

    public void setMonday(String monday) {
        Monday = monday;
    }

    public String getTuesday() {
        return Tuesday;
    }

    public void setTuesday(String tuesday) {
        Tuesday = tuesday;
    }

    public String getWednesday() {
        return Wednesday;
    }

    public void setWednesday(String webnesday) {
        Wednesday = webnesday;
    }

    public String getThursday() {
        return Thursday;
    }

    public void setThursday(String thursday) {
        Thursday = thursday;
    }

    public String getFriday() {
        return Friday;
    }

    public void setFriday(String friday) {
        Friday = friday;
    }

    public String getSaturday() {
        return Saturday;
    }

    public void setSaturday(String saturday) {
        Saturday = saturday;
    }

    public String getSunday() {
        return Sunday;
    }

    public void setSunday(String sunday) {
        Sunday = sunday;
    }

    @Override
    public String toString() {
        return "courseItem{" +
                "Time=" + Time +
                ", Monday='" + Monday + '\'' +
                ", Tuesday='" + Tuesday + '\'' +
                ", Webnesday='" + Wednesday + '\'' +
                ", Thursday='" + Thursday + '\'' +
                ", Friday='" + Friday + '\'' +
                ", Saturday='" + Saturday + '\'' +
                ", Sunday='" + Sunday + '\'' +
                '}';
    }
}
