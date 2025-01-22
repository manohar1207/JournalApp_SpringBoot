package com.NewProject.journalApp.Repository;
import com.NewProject.journalApp.Entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry , String>{
}
