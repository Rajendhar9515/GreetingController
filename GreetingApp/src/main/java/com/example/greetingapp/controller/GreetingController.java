package com.example.greetingapp.controller;

import com.example.greetingapp.entity.User;
import com.example.greetingapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController

public class GreetingController {

    @Autowired
    UserService userService;

//    UC-1
    @RequestMapping("/showAll")
    public List<User> displayAll(){
        return userService.display();
    }

//    UC-2
    @GetMapping("/message")
    public String message(){
        return userService.showMessage();
    }

//    UC-3
    @GetMapping(value={"/get", "/get/{firstName}","/get/{firstName}/{lastName}"})
    public String sayHello(@PathVariable(required = false) String firstName, @PathVariable(required = false) String lastName ){
        if(firstName != null && lastName != null){
            return "Hello " + firstName + " " + lastName;
        } else if(firstName != null || lastName != null) {
            String value = firstName != null ? firstName : lastName;
            return  "Hello " +value;
        }
        return "Hello World";
    }

//    UC-4
    List<User> list = new ArrayList<>();
    @PostMapping("/save")
    public User saveData(@RequestBody User user){
        return  userService.save(user);
    }

//    UC-5
    @GetMapping("/find/{id}")
    public Optional<User> findById(@PathVariable int id ){
        return userService.findById(id);
    }

//    UC-6
    @GetMapping("/show")
    public List<User> display(){
        return userService.display();
    }

//    UC-7
    @PutMapping("/edit")
    public User Edit(@RequestBody User user){
        return userService.update(user);
    }

//    UC-8
    @DeleteMapping("/remove/{id}")
    public void delete(@PathVariable int id){
        userService.deleteById(id);
   }
}
