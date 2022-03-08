package com.xm.boot.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author mintFM
 * @create 2021-12-04 10:17
 */
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class User {
    private String name;
    private Integer age;
    private Pet pet;

    public User(String name,Integer age) {
        this.name = name;
        this.age = age;
    }
}
