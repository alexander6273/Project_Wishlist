package com.projectwishlist.controllers;

import com.projectwishlist.models.User;
import com.projectwishlist.repositories.UserRep;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class UserController
{

    //public String checkUser(@RequestParam ( value = "username", required = false), @RequestParam (value = "password", ){
    @PostMapping("/checkUser")
    public String checkUser(WebRequest data){
        UserRep userRep = new UserRep();
        System.out.println(data.getParameter("username"));
        System.out.println(data.getParameter("password"));
        System.out.println("heffa");
        try{
            boolean test = true;
            if(test) {
                return "wishlist";
            } else {
                return "lol";
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return "fejl";
    }
}
