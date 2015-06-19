package com.learn.spring.entity;

import org.springframework.data.annotation.Id;

/**
 * Created by gabbi on 19.06.15.
 */
public class Contact {
    @Id
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
