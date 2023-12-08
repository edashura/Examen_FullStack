package com.examen.examen_fullstack.service;

import com.examen.examen_fullstack.entity.EvaluationEntity;
import com.examen.examen_fullstack.entity.EvaluationFinaleEntity;
import com.examen.examen_fullstack.entity.RestaurantEntity;
import com.examen.examen_fullstack.repository.EvaluationFinaleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluationFinaleService {
    private final EvaluationFinaleRepository evaluationFinaleRepository;
    private final RestaurantService restaurantService;

    public EvaluationFinaleEntity addEvaluationFinale(int restaurantId, String decideurName, Double finalnote, String evaluateurEvaluation) {
        final RestaurantEntity restaurant = restaurantService.getRestaurantById(restaurantId);
        final EvaluationFinaleEntity nouvelleEvaluationFinale = EvaluationFinaleEntity.builder().deciderName(decideurName).finalStars(finalnote).descriptiveText(evaluateurEvaluation).restaurant(restaurant).build();

        return this.evaluationFinaleRepository.save(nouvelleEvaluationFinale);
    }

    public List<EvaluationFinaleEntity> getEvaluationFinale(){
        return this.evaluationFinaleRepository.findAll();
    }
}
