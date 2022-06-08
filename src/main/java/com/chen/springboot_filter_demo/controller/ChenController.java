package com.chen.springboot_filter_demo.controller;

import com.chen.springboot_filter_demo.entity.Chen;
import com.chen.springboot_filter_demo.service.ChenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * (Chen)表控制层
 *
 * @author makejava
 * @since 2022-06-07 22:48:31
 */
@Controller
@RequestMapping("/api")
public class ChenController {
    /**
     * 服务对象
     */
    @Autowired
    private ChenService chenService;

    @GetMapping("/list")
    public List<Chen> list() {

        return chenService.findAll();
    }

    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, Model model) {

        /*String un = (String) request.getSession().getAttribute("username");
        if (un != null){
            request.getSession().removeAttribute("username");
        }*/
        System.out.println("进入控制器");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //model.addAttribute("username",username);
        request.getSession().setAttribute("username", username);//储存到session中
        try {
            if (chenService.findById(username, password)) {
                System.out.println("success");
                return "redirect:/list/all";
            }
            return "fail";
        } catch (Exception ex) {
            System.out.println("登陆出错");
            return "fail";
        }
    }
}

