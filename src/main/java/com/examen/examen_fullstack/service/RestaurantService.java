package com.examen.examen_fullstack.service;

import com.examen.examen_fullstack.entity.EvaluationEntity;
import com.examen.examen_fullstack.entity.RestaurantEntity;
import com.examen.examen_fullstack.exception.RessourceDoesntExist;
import com.examen.examen_fullstack.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantEntity getRestaurantById(int id) {
        return this.restaurantRepository.findById(id).orElseThrow(() -> new RessourceDoesntExist("restaurant n°" + id + " n'exite pas"));
    }

    public List<RestaurantEntity> getAllRestaurants(){
        return this.restaurantRepository.findAll();
    }

    public RestaurantEntity addRestaurant(final String nom, final String adresse) {
        EvaluationEntity comm = EvaluationEntity.builder().build();
        List<EvaluationEntity> nouvelleEval = new ArrayList<EvaluationEntity>();
        nouvelleEval.add(comm);
        final RestaurantEntity nouveauRestaurant = RestaurantEntity.builder().nom(nom).adresse(adresse).evaluations(nouvelleEval).build();
        return this.restaurantRepository.save(nouveauRestaurant);
    }
}