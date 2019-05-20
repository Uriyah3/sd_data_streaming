package com.streaming.wiki.rest;


import com.streaming.wiki.repository.Wikipedia_Entries_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/wiki")
public class Wikipedia_Entries_Service {

    @Autowired
    private Wikipedia_Entries_Repository wikipedia_entries_repository;

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getAllEntries(){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(wikipedia_entries_repository.findAll());
        }
        catch (Exception e){
            String jsonResponse = "{\"response\":400,\"message\":\""+e.toString()+"\"}";
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(jsonResponse);
        }
    }
}
