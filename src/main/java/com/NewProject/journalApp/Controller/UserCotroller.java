package com.NewProject.journalApp.Controller;

import com.NewProject.journalApp.Entity.User;
import com.NewProject.journalApp.Service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserCotroller {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllEntry();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        userService.saveEntry(user);
        return user;
    }
    /*@GetMapping("id/{objectId}")
    public Optional<User> getUserById(@PathVariable ObjectId objectId){
        return userService.getById(objectId);
    }

    @DeleteMapping("id/{objectId}")
    public Boolean deleteById(@PathVariable ObjectId objectId){
        userService.deleteByID(objectId);
        return true;
    }*/

    @PutMapping("/{userName}")
    public ResponseEntity<?> UpdateUser(@RequestBody User user,@PathVariable String userName){
        User userDb = userService.findByUserName(userName);
        if(userDb!=null){
            userDb.setUserName(user.getUserName());
            userDb.setPassword((user.getPassword()));
            userService.saveEntry(userDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
