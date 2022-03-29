package com.projectwishlist.controllers;

import com.projectwishlist.models.User;
import com.projectwishlist.repositories.DatabaseRep;
import com.projectwishlist.repositories.UserRep;
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
        try {
            User user = userRep.getUserFromDb(1);
            return user.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            return databaseRep.getAllItems();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Hej med dig";
    }
}
