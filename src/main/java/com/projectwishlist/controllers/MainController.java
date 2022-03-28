package com.projectwishlist.controllers;

import com.projectwishlist.services.DatabaseServices;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class MainController
{
    DatabaseServices databaseServices = new DatabaseServices();
    //Controller methods
    @GetMapping("/")
    public String index() {
        System.out.println("LOL");
        return "fejl";
    }
    @GetMapping("/lol")
    public String lol(){
        try {
            return databaseServices.getAllItems();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Hej med dig";
    }
}
