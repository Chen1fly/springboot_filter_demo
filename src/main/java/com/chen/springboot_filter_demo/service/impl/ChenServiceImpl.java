package com.chen.springboot_filter_demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.chen.springboot_filter_demo.entity.Chen;
import com.chen.springboot_filter_demo.dao.ChenDao;
import com.chen.springboot_filter_demo.service.ChenService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;


import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * (Chen)表服务实现类
 *
 * @author makejava
 * @since 2022-06-07 22:48:34
 */
@Service("chenService")
public class ChenServiceImpl implements ChenService {
    @Autowired
    private RedisTemplate<String, String> redisTemplate;


    @Resource
    private ChenDao chenDao;

    @Override
    public List<Chen> findAll() {
        //增加缓存
        //先去缓存查找，如果缓存有 直接返回 如果缓存没有 从数据库查询 放入缓存
        String userListJsonStr = redisTemplate.opsForValue().get("UserService.findAll");
        if (StringUtils.isNotBlank(userListJsonStr)) {
            List<Chen> chens = JSON.parseArray(userListJsonStr, Chen.class);
            System.out.println("走了缓存");
            return chens;
        } else {
            List<Chen> chens = chenDao.findAll();
            redisTemplate.opsForValue().set("UserService.findAll", JSON.toJSONString(chens), 20, TimeUnit.SECONDS);
            System.out.println("首次放入缓存");
            return chens;
        }
    }

    @Override
    public Boolean findById(String username, String password) {
        Boolean bool;
        if(chenDao.findById(username,password)){
            bool = true;
        }else {
            bool = false;
        }
        return bool;
    }
}
