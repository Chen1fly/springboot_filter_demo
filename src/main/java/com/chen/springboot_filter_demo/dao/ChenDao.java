package com.chen.springboot_filter_demo.dao;

import com.chen.springboot_filter_demo.entity.Chen;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Chen)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-07 22:48:31
 */
public interface ChenDao {
    List<Chen> findAll();

    Boolean findById(@Param("username") String username, @Param("password") String password);
}

