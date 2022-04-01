package com.projectwishlist.repositories;

import com.projectwishlist.models.User;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserRep {
 private User user;
 private final DatabaseRep databaseRep;

    public UserRep() {
        this.databaseRep = new DatabaseRep();
    }

    public ArrayList<String> getUserFromDb(int userId) throws SQLException {
        ArrayList<String> user = new ArrayList<>();
        /* SELECT * FROM Db_test.users WHERE user = '1'*/
        String sql = "SELECT * FROM projectwishlist.user WHERE user_id = " + "'" + userId + "'";
        ResultSet resultSet = databaseRep.getResultSet(sql);

        String username = null;
        String password = null;
        String firstName = null;

        while (resultSet.next()) {
            username = resultSet.getString("user_username");
            password = resultSet.getString("user_password");
            firstName = resultSet.getString("user_firstname");
        }
        if(username != null) {
            //user = new User(userId, username, password, firstName);
            String userIdString = String.valueOf(userId);
            user.add(userIdString);
            user.add(username);
            user.add(password);
            user.add(firstName);
        }
        return user;
     }
     
     
     public boolean authenticateUser(String usernameInput, String passwordInput) throws SQLException {
         String sql = "SELECT ('username', 'password') FROM projectwishlist.user WHERE username = " + "'" + usernameInput + "'";
         ResultSet resultSet = databaseRep.getResultSet(sql);

         String username = null;
         String password = null;

         while (resultSet.next()) {
             username = resultSet.getString("user_username");
             password = resultSet.getString("user_password");
         }

         if (username != null && !username.equals(usernameInput)) return false;
         assert password != null;
         return password.equals(passwordInput);
     }

    
    
}
