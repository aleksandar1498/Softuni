package com.cardealer.cardealer.services;

import com.cardealer.cardealer.entities.User;
import com.cardealer.cardealer.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public void saveUser(User user){
        this.userRepository.save(user);
    }
    public List<User> showUsersByIdAsc(){
        return this.userRepository.findAllByOrOrderByIdAsc();
    }
    public List<User> showUsersByIdDesc(){
        return this.userRepository.findAllByOrOrderByIdDesc();
    }
}

