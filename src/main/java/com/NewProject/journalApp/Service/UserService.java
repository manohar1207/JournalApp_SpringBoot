package com.NewProject.journalApp.Service;

import com.NewProject.journalApp.Entity.JournalEntry;
import com.NewProject.journalApp.Entity.User;
import com.NewProject.journalApp.Repository.JournalEntryRepository;
import com.NewProject.journalApp.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveEntry(@RequestBody User user){

        userRepository.save(user);
    }

    public List<User> getAllEntry(){
        return userRepository.findAll();
    }

    public void deleteAllEntry(){
        userRepository.deleteAll();
    }

    public void deleteByID(ObjectId id){
        userRepository.deleteById(id);
    }

    public Optional<User> getById(ObjectId id){
        return userRepository.findById(id);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
