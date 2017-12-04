package com.bean;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author shanglei
 * @date 2017/10/18.
 */
@Getter
@Setter
@ToString
public class User implements Serializable {
    private static final long serialVersionUID = -6092707019316061144L;
    private Integer id;
    private String name;
    private Integer age;
    private String mark;
    private int marks;
}
