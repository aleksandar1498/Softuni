package com.cardealer.cardealer.controllers;

import com.cardealer.cardealer.entities.User;
import com.cardealer.cardealer.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller()
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/save")
    @ResponseBody
    public String saveUser() {
        User user = new User();
        user.setName(user.getId()+"Alex");
        this.userService.saveUser(user);
        return user.getId()+" "+user.getName()+" saved";
    }
    @GetMapping("/show/asc")
    @ResponseBody
    public String showUserAsc() {
        List<User> users = this.userService.showUsersByIdAsc();
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : users) {
            stringBuilder.append(user.getId()+" "+user.getName()).append("</br>");
        }
        return stringBuilder.toString();
    }
    @GetMapping("/show/desc")
    @ResponseBody
    public String showUserDesc() {
        List<User> users = this.userService.showUsersByIdDesc();
        StringBuilder stringBuilder = new StringBuilder();
        for (User user : users) {
            stringBuilder.append(user.getId()+" "+user.getName()).append("</br>");
        }
        return stringBuilder.toString();
    }
}
