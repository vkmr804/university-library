package com.ucm.library.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ucm.library.dto.AuthorRequest;
import com.ucm.library.entity.AuthorDaoModel;
import com.ucm.library.model.Author;
import com.ucm.library.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Author createAuthor(AuthorRequest AuthorRequest) {
        AuthorDaoModel AuthorDaoModel = new AuthorDaoModel(
                AuthorRequest.getName()
        );
        AuthorDaoModel createdAuthor = authorRepository.save(AuthorDaoModel);
        return new Author(createdAuthor.getId(), createdAuthor.getName());
    }

    public Author getAuthor(Long id) {
        Optional<AuthorDaoModel> AuthorDaoModel = authorRepository.findById(id);
        if (AuthorDaoModel.isPresent()) {
            AuthorDaoModel authorDaoModelData = AuthorDaoModel.get();
            return new Author(authorDaoModelData.getId(), authorDaoModelData.getName());
        } else {
            throw new ResourceNotFoundException("No Resource Found with the given Id");
        }
    }

    public List<Author> getAllAuthors() {
        List<AuthorDaoModel> authorDaoModels = authorRepository.findAll();
        return authorDaoModels.stream().map(AuthorDaoModel -> new Author(
                AuthorDaoModel.getId(), AuthorDaoModel.getName()
        )).collect(Collectors.toList());
    }
}
