package com.chen.springboot_filter_demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chen.springboot_filter_demo.entity.Chen;
import com.chen.springboot_filter_demo.service.ChenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author Chenyifei
 * @version 1.0
 * @date 2022/6/8 14:17
 */
@Controller
@RequestMapping("/list")
public class ListController {

    @Autowired
    private ChenService chenService;

    public void clearSession(HttpServletRequest request){
        String un = (String) request.getSession().getAttribute("username");
        if (un != null){
            request.getSession().removeAttribute("username");
        }
    }

    @RequestMapping("/all")
    public String list_all(Model model,HttpServletRequest request) {
        //clearSession(request);
        List<Chen> user = chenService.findAll();
        model.addAttribute("user",user);
        return "/list";
    }
}
