package com.yinghua.liu.blog.blog.controller;

import com.yinghua.liu.blog.blog.dao.UserDao;
import com.yinghua.liu.blog.blog.entity.User;
import com.yinghua.liu.blog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userRepository;
    @Autowired
    private UserService userService;
//    @Autowired
//    private TestXmlBean testXmlBean;
    @Value("${dubbo.projectName}")
    private String dubboStr;

    @RequestMapping("/getUser")
    public User getUser(){
//        System.out.println("apollo==="+testXmlBean.toString());
        User user = userRepository.findByUserName("yinghua");
        System.out.println("若下面没出现'无缓存调用'字样且能打印出数据则表示测试成功");
        System.out.println("user:"+user.toString());
        System.out.println("dubboName:"+dubboStr);
        return user;
    }

    /**
     * 通过id 查询User对象
     * @param id
     * @return
     */
    @RequestMapping(value = "/api/findinfo/{id}")
    public User findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }
    /**
     * 保存用户信息
     * @param user
     */
    @RequestMapping(value = "/api/create")
    public void saveUser(User user) {
        userService.saveUser(user);

    }
    /**
     * 更改用户信息
     * @param user
     */
    @RequestMapping(value = "/api/modify")
    public void updateUser(User user) {
        userService.updateUser(user);
    }
    /**
     * 删除用户信息
     * @param id
     */
    @RequestMapping(value = "/api/delete/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
    }
}
