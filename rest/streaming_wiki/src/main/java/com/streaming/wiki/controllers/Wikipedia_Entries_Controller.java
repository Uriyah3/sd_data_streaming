package com.streaming.wiki.controllers;

import com.streaming.wiki.models.Wikipedia_Entries;
import com.streaming.wiki.repositories.Wikipedia_Entries_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/wiki_entries_100")
    public List<Wikipedia_Entries> getFirst100Entries() {
        Pageable sortedByIdDesc = PageRequest.of(0, 100, Sort.by("entryid").descending());
        Page<Wikipedia_Entries> last100entries = wikipedia_entries_repository.findAll(sortedByIdDesc); // as a page
        return last100entries.getContent(); // as a list
    }

}
