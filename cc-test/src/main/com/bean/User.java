package com.bean;

import java.io.Serializable;

/**
 * @author shanglei
 * @date 2017/10/18.
 */
public class User implements Serializable {
    private static final long serialVersionUID = -6092707019316061144L;
    private String name;
    private Integer age;
    private String mark;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMark() {
        return this.mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "User{" +
            "name='" + name + '\'' +
            ", age=" + age +
            ", mark='" + mark + '\'' +
            '}';
    }
}
