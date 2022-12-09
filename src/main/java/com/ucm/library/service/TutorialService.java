package com.ucm.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucm.library.dto.TutorialRequest;
import com.ucm.library.dto.TutorialUpdateRequest;
import com.ucm.library.entity.AuthorDaoModel;
import com.ucm.library.entity.TutorialDaoModel;
import com.ucm.library.model.Tutorial;
import com.ucm.library.repository.AuthorRepository;
import com.ucm.library.repository.TutorialRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TutorialService {

    private final TutorialRepository tutorialRepository;
    private final AuthorRepository authorRepository;

    @Autowired
    public TutorialService(TutorialRepository tutorialRepository, AuthorRepository authorRepository) {
        this.tutorialRepository = tutorialRepository;
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Tutorial createTutorial(TutorialRequest tutorialRequest) {
        AuthorDaoModel authorDaoModel = authorRepository.findById(tutorialRequest.getAuthor_id()).get();
        TutorialDaoModel tutorialDaoModel = new TutorialDaoModel(
                tutorialRequest.getTitle(),
                tutorialRequest.getDescription(),
                tutorialRequest.isPublished(),
                authorDaoModel
        );
        TutorialDaoModel createdTutorial = tutorialRepository.save(tutorialDaoModel);
        return new Tutorial(createdTutorial.getId(), createdTutorial.getTitle(), createdTutorial.getDescription(), createdTutorial.isPublished(), authorDaoModel.getName());
    }

    public Tutorial getTutorial(Long id) {
        Optional<TutorialDaoModel> tutorialDaoModel = tutorialRepository.findById(id);
        if (tutorialDaoModel.isPresent()) {
            TutorialDaoModel tutorialDaoModelData = tutorialDaoModel.get();
            AuthorDaoModel authorDaoModel = authorRepository.findById(tutorialDaoModelData.getAuthor().getId()).get();
            return new Tutorial(tutorialDaoModelData.getId(), tutorialDaoModelData.getTitle(), tutorialDaoModelData.getDescription(), tutorialDaoModelData.isPublished(), authorDaoModel.getName());
        } else {
            throw new ResourceNotFoundException("No Resource Found with the given Id");
        }
    }

    public List<Tutorial> getAllTutorials() {
        List<TutorialDaoModel> tutorialDaoModels = tutorialRepository.findAll();
        return tutorialDaoModels.stream().map(tutorialDaoModel -> new Tutorial(
                tutorialDaoModel.getId(), tutorialDaoModel.getTitle(), tutorialDaoModel.getDescription(), tutorialDaoModel.isPublished(), tutorialDaoModel.getAuthor().getName()
        )).collect(Collectors.toList());
    }

    @Transactional
    public void deleteTutorial(Long id) {
        Optional<TutorialDaoModel> tutorialDaoModel = tutorialRepository.findById(id);
        if (tutorialDaoModel.isPresent()) {
            tutorialRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("No Resource Found with the given Id");
        }
    }

    @Transactional
    public Tutorial updateTutorial(Long id, TutorialUpdateRequest tutorialRequest) {
        Optional<TutorialDaoModel> existingTutorialDaoModel = tutorialRepository.findById(id);
        if (existingTutorialDaoModel.isPresent()) {
            TutorialDaoModel tutorialDaoModel = new TutorialDaoModel(
                    existingTutorialDaoModel.get().getId(),
                    tutorialRequest.getTitle(),
                    tutorialRequest.getDescription(),
                    tutorialRequest.isPublished(),
                    existingTutorialDaoModel.get().getAuthor()
            );
            TutorialDaoModel updatedTutorial = tutorialRepository.save(tutorialDaoModel);
            return new Tutorial(updatedTutorial.getId(), updatedTutorial.getTitle(), updatedTutorial.getDescription(), updatedTutorial.isPublished(), updatedTutorial.getAuthor().getName());

        } else {
            throw new ResourceNotFoundException("No Resource Found with the given Id");
        }
    }

    public void deleteTutorials() {
        tutorialRepository.deleteAll();
    }
}
