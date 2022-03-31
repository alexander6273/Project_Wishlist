package com.projectwishlist.controllers;

import com.projectwishlist.models.User;
import com.projectwishlist.repositories.DatabaseRep;
import com.projectwishlist.repositories.UserRep;
import com.projectwishlist.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class MainController
{
    DatabaseRep databaseRep = new DatabaseRep();
    //Controller methods
    @GetMapping("/")
    public String index() {
        System.out.println("LOL");
        return "fejl";
    }
    @GetMapping("/lol")
    public String lol(){

        UserRep userRep = new UserRep();
        UserService userService = new UserService();
        User user = userService.getUserFromId(1);
        return user.toString();
    }

    @GetMapping("/alextest")
    public void test(){

        DatabaseRep dbr = new DatabaseRep();

        dbr.insertdata("item", "item_name, item_price, item_link", "'seng', '200', 'test'");

    }
}
