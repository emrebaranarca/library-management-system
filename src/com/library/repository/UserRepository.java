package com.library.repository;

import com.library.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    //id,user
    private Map<String, User> userMap;

    public UserRepository() {
        this.userMap = new HashMap<>();
    }

    //create
    public void addUser(User user) {
        this.userMap.put(user.getIdentityNumber(),user);
    }

    //read
    public User getUser(String identityNumber) {
        return this.userMap.get(identityNumber);
    }

    //update
    public void updateUser(User user) {
        this.userMap.put(user.getIdentityNumber(), user);
    }

    //delete
    public void deleteUser(String identityNumber) {
        this.userMap.remove(identityNumber);
    }
}
