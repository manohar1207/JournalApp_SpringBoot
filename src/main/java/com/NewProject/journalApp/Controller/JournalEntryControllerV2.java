package com.NewProject.journalApp.Controller;

import com.NewProject.journalApp.Entity.JournalEntry;
import com.NewProject.journalApp.Service.JournelEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournelEntryService journelEntryService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        try{
            List<JournalEntry> all = journelEntryService.getAllEntry();
            if(all!=null && !all.isEmpty()){
                return new  ResponseEntity<>(all, HttpStatus.OK);
            }
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createEntry(@RequestBody JournalEntry journalEntry){
        try {
            journalEntry.setDate(LocalDateTime.now());
            journelEntryService.saveEntry(journalEntry);
            return new  ResponseEntity<>(journalEntry, HttpStatus.OK);
        } catch (Exception e) {
            return new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("id/{myId}")
    public ResponseEntity<?> getEntryById(@PathVariable ObjectId  myId){
        Optional<JournalEntry> journalEntry = journelEntryService.getById(myId);
        if(journalEntry.isPresent()){
           return new  ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId  myId){
        Optional<JournalEntry> journalEntry = journelEntryService.getById(myId);
        if(journalEntry.isPresent()){
            journelEntryService.deleteByID(myId);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<?> updateEntryById(@PathVariable ObjectId  myId,@RequestBody JournalEntry newEntry){
        JournalEntry old = journelEntryService.getById(myId).orElse(null);
        if(old!=null){
            old.setTitle(newEntry.getTitle()!=null && !newEntry.getTitle().equals("")?newEntry.getTitle(): old.getTitle());
            old.setContent(newEntry.getContent()!=null && !newEntry.getContent().equals("") ? newEntry.getContent() : old.getContent());
            journelEntryService.saveEntry(old);
            return new ResponseEntity<>(old,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
