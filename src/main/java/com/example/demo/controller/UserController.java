package com.example.demo.controller;

import com.example.demo.model.Result;
import com.example.demo.model.User;
import com.example.demo.reponsitory.UserJpaRepository;
import com.example.demo.reponsitory.UserRepository;
import com.example.demo.service.IUserService;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author luogeng.szq
 * @version $$Id:UserController.java, v0.1 2018/2/6 下午4:40 Exp$$
 **/

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/register")
    @JsonFormat
    public User register() {

        //@Param("user") User user
        //if (user == null ||
        //    StringUtils.isEmpty(user.getUsername()) ||
        //    StringUtils.isEmpty(user.getPassword()) ||
        //    StringUtils.isEmpty(user.getNick())) {
        //
        //    return Result.paramError();
        //}
        User user = new User();
        user.setUsername("sunzhi");
        user.setPassword("123456");
        user.setNick("船长");

        user.setGmtCreate(new Date());
        user.setGmtModify(new Date());

        User u = userJpaRepository.save(user);

        return u;
    }


    @RequestMapping("/login")
    @JsonFormat
    public Result login(@Param("username")String username, @Param("password")String password) {

        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return Result.paramError();
        }

        User user = userRepository.findByName(username);

        if (user == null) {
            return Result.paramError();
        }

        if (password.equals(user.getPassword())) {
            return Result.isOk();
        }

        return Result.paramError();
    }

}
