package com.example.greetingapp.service;

import com.example.greetingapp.entity.User;
import com.example.greetingapp.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public User save(User user) {
        return userRepo.save(user);
    }
    public List<User> display(){
        List<User> user = userRepo.findAll();
        return user;
    }
    public User update(User user){
        return userRepo.save(user);
    }

    public String showMessage(){
        return "Hello World";
    }


    public Optional<User> findById(Integer id) {
        return userRepo.findById(id);
    }

    public void deleteById(int id) {
         userRepo.deleteById(id);
    }
}
