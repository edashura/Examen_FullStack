package com.examen.examen_fullstack.repository;

import com.examen.examen_fullstack.entity.EvaluationFinaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvaluationFinaleRepository extends JpaRepository<EvaluationFinaleEntity, Integer> {
}
