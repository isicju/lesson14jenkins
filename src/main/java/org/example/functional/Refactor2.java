package org.example.functional;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Refactor2 {
   private List<User> users;

   public List<User> findUserById(String name){
       List<User> usersResult = new ArrayList<>();
       for (User user: users){
           if (user.getFirstName() == name){
               usersResult.add(user);
           }
       }
       return usersResult;
   }

    public User findSomeUserByLastName(String name){
        List<User> usersResult = new ArrayList<>();
        for (User user: users){
            if (user.getLastName() == name){
                return user;
            }
        }
        return null;
    }

}
