package com.chen.springboot_filter_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(value = "com.chen.springboot_filter_demo.dao")
@ServletComponentScan//注册filter方法1
public class SpringbootFilterDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootFilterDemoApplication.class, args);
    }
    /**
     * 注册Filter方法2
     */
   /* @Bean
    public FilterRegistrationBean getFilterRegistrationBean(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new LoginFilter());
        //bean.addUrlPatterns(new String[]{"*.do","*.jsp"});
        //bean.addUrlPatterns("/second");
        return bean;
    }*/

}
