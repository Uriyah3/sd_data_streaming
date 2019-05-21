package com.streaming.wiki.controllers;

import com.streaming.wiki.models.Wikipedia_Entries;
import com.streaming.wiki.repositories.Wikipedia_Entries_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api")
public class Wikipedia_Entries_Controller {

    @Autowired
    Wikipedia_Entries_Repository wikipedia_entries_repository;

    @GetMapping("/wiki_entries")
    public List<Wikipedia_Entries> getAllEntries(){
        return wikipedia_entries_repository.findAll();
    }
}
