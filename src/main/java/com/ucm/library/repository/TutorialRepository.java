package com.ucm.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ucm.library.entity.TutorialDaoModel;

@Repository
public interface TutorialRepository extends JpaRepository<TutorialDaoModel, Long> {
}
