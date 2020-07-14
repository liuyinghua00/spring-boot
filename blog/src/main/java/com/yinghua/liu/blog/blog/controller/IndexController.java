package com.yinghua.liu.blog.blog.controller;

import com.yinghua.liu.blog.blog.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(Model model){
        List<User> users = new ArrayList<>();
        for(int i=0;i<3;i++){
            User u = new User();
            u.setUserName("张三"+i);
            u.setEmail("ksk="+i);
            u.setId(i);
            users.add(u);
        }
        model.addAttribute("user",users);
        return "index";
    }
}
