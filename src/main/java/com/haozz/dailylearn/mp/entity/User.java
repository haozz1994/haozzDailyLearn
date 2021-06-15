package com.haozz.dailylearn.mp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author
 * @date 2020/1/4 15:09
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long id;

    private Integer age;

    private String name;

    private String address;

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
