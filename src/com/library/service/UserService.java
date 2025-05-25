package com.library.service;

import com.library.model.User;
import com.library.repository.UserRepository;
import com.library.service.interfaces.IUserService;


public class UserService implements IUserService {
    private UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    //post
    @Override
    public void addUser(User user) {
        this.userRepository.addUser(user);
    }

    //get
    @Override
    public User getUser(String identityNumber) {
        return this.userRepository.getUser(identityNumber);
    }

    //update
    @Override
    public void updateUser(User user) {
        this.userRepository.updateUser(user);
    }

    //delete
    @Override
    public void deleteUser(String identityNumber) {
        this.userRepository.deleteUser(identityNumber);
    }
}
