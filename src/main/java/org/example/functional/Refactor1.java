package org.example.functional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Refactor1 {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(); //assuming list been initialized here

        List<User> lowIncomeNY = List.of();
        for (User user: users){
            if (user.getCity() == "New York"){
                if (user.getSalary() < 100L){
                    lowIncomeNY.add(user);
                }
            }
        }
        Map<String, User> lowIncomeCitizensMap = new HashMap<>();
        for (User citizen: lowIncomeNY){
            lowIncomeCitizensMap.put(citizen.getGuid(), citizen);
        }

        if(lowIncomeCitizensMap.size() > 10){
            System.out.println(" there are more than 10 guys in NY with low income.");
        }
    }


}
