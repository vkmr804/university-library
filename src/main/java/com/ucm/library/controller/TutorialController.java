package com.ucm.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ucm.library.dto.TutorialRequest;
import com.ucm.library.dto.TutorialUpdateRequest;
import com.ucm.library.model.Tutorial;
import com.ucm.library.service.TutorialService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("v1/tutorials")
public class TutorialController {

    private final TutorialService tutorialService;

    @Autowired
    public TutorialController(TutorialService tutorialService) {
        this.tutorialService = tutorialService;
    }

    @PostMapping
    public ResponseEntity<Tutorial> createTutorial(@RequestBody TutorialRequest tutorialRequest) {
        return new ResponseEntity<>(tutorialService.createTutorial(tutorialRequest), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") long id) {
        return new ResponseEntity<>(tutorialService.getTutorial(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Tutorial>> getAllTutorials() {
        return new ResponseEntity<>(tutorialService.getAllTutorials(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
        tutorialService.deleteTutorial(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteAllTutorial() {
        tutorialService.deleteTutorials();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") long id, @RequestBody TutorialUpdateRequest tutorialRequest) {
        return new ResponseEntity<>(tutorialService.updateTutorial(id, tutorialRequest), HttpStatus.ACCEPTED);
    }

}