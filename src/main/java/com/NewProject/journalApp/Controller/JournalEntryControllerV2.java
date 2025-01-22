package com.NewProject.journalApp.Controller;

import com.NewProject.journalApp.Entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @GetMapping
    public List<JournalEntry> getAll(){
        return null;
    }

    @PostMapping
    public long createEntry(@RequestBody JournalEntry journalEntry){
        return 0L;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getEntryById(@PathVariable Long  myId){
        return null;

    }

    @DeleteMapping("id/{myId}")
    public JournalEntry deleteEntryById(@PathVariable Long  myId){
        return null;
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateEntryById(@PathVariable Long  myId,@RequestBody JournalEntry journalEntry){
        return null;
    }
}
