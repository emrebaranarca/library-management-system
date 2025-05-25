package com.library.service.interfaces;

import com.library.model.User;

public interface IUserService {
    //post
     void addUser(User user);

    //get
     User getUser(String identityNumber);

    //update
     void updateUser(User user);

    //delete
     void deleteUser(String identityNumber);
}
