package com.NewProject.journalApp.Repository;
import com.NewProject.journalApp.Entity.JournalEntry;
import com.NewProject.journalApp.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry , ObjectId>{

}
