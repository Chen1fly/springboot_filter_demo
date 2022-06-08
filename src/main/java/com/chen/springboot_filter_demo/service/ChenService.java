package com.chen.springboot_filter_demo.service;

import com.chen.springboot_filter_demo.entity.Chen;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (Chen)表服务接口
 *
 * @author makejava
 * @since 2022-06-07 22:48:34
 */
public interface ChenService {
    /*查询所有*/
    List<Chen> findAll();
    Boolean findById(String username,String password);


}
