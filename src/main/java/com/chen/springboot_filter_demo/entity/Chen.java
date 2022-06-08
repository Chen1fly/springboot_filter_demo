package com.chen.springboot_filter_demo.entity;

import java.io.Serializable;

/**
 * (Chen)实体类
 *
 * @author makejava
 * @since 2022-06-07 22:48:31
 */
public class Chen implements Serializable {
    private static final long serialVersionUID = 149959650719709310L;
    
    private Integer id;
    
    private String name;
    
    private String sex;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}

