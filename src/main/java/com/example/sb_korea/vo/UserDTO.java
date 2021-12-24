package com.example.sb_korea.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author hao.wong
 * @date 2021/12/24
 */
public class UserDTO implements Serializable {

    private String name;
    private String age;

    //yyyy-MM-dd HH:mm:ss
    private String time;

    private String before;
    private String after;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBefore() {
        return before;
    }

    public void setBefore(String before) {
        this.before = before;
    }

    public String getAfter() {
        return after;
    }

    public void setAfter(String after) {
        this.after = after;
    }
}
