package com.examen.examen_fullstack.service;

import com.examen.examen_fullstack.entity.EvaluationEntity;
import com.examen.examen_fullstack.entity.RestaurantEntity;
import com.examen.examen_fullstack.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluationService {
    private final EvaluationRepository evaluationRepository;
    private final RestaurantService restaurantService;

    public EvaluationEntity addEvaluation(int restaurantId, String commentaireEvaluation, String evaluateurEvaluation, Integer etoile) {
        final RestaurantEntity restaurant = restaurantService.getRestaurantById(restaurantId);
        final EvaluationEntity nouvelleEvaluation = EvaluationEntity.builder().commentaire(commentaireEvaluation).etoile(etoile).evaluateurName(evaluateurEvaluation).restaurant(restaurant).build();

        return this.evaluationRepository.save(nouvelleEvaluation);
    }

    public List<EvaluationEntity> getAllEvaluations(){
        return this.evaluationRepository.findAll();
    }
}