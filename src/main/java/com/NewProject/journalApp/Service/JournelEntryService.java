package com.NewProject.journalApp.Service;

import com.NewProject.journalApp.Entity.JournalEntry;
import com.NewProject.journalApp.Entity.User;
import com.NewProject.journalApp.Repository.JournalEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class JournelEntryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public void saveEntry(JournalEntry journalEntry){

        journalEntryRepository.save(journalEntry);
    }

    public List<JournalEntry> getAllEntry(){
        return journalEntryRepository.findAll();
    }

    public void deleteAllEntry(){
        journalEntryRepository.deleteAll();
    }

    public void deleteByID(ObjectId id){
        journalEntryRepository.deleteById(id);
    }

    public Optional<JournalEntry> getById(ObjectId id){
        return journalEntryRepository.findById(id);
    }


}
