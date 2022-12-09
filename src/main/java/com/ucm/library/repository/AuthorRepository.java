package com.ucm.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ucm.library.entity.AuthorDaoModel;

public interface AuthorRepository extends JpaRepository<AuthorDaoModel, Long> {
}
