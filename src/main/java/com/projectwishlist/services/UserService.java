package com.projectwishlist.services;

import com.projectwishlist.models.User;
import com.projectwishlist.repositories.UserRep;

import java.sql.SQLException;
import java.util.ArrayList;

public class UserService {
    UserRep userRep;

    public UserService() {
        this.userRep = new UserRep();
    }

    /*public User getUserFromId(int userId){
        User user = null;
        try {
            ArrayList<String> userInformation = userRep.getUserFromDb(userId);
            int user_id = Integer.parseInt(userInformation.get(0));
            String username = userInformation.get(1);
            String password = userInformation.get(2);
            String firstName = userInformation.get(3);
            
            user = new User(userId,username, password, firstName);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return user;
    }*/
}
