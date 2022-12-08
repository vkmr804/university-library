package com.ucm.thesis.repository;

import com.ucm.thesis.entity.AuthorDaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<AuthorDaoModel, Long> {
}
