package com.ucm.thesis.repository;

import com.ucm.thesis.entity.TutorialDaoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TutorialRepository extends JpaRepository<TutorialDaoModel, Long> {
}
