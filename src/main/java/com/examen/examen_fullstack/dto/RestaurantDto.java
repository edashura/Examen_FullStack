package com.examen.examen_fullstack.dto;

import com.examen.examen_fullstack.entity.EvaluationEntity;
import com.examen.examen_fullstack.entity.EvaluationFinaleEntity;
import com.examen.examen_fullstack.entity.RestaurantEntity;
import com.examen.examen_fullstack.entity.TagEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class RestaurantDto {

    @JsonProperty("id")
    private int id;

    @JsonProperty("nom")
    @Size(max = 90)
    private String nom;

    @JsonProperty("adresse")
    @Size(max = 255)
    private String adresse;

    @JsonProperty("evaluations")
    private List<EvaluationDto> evaluations;

    @JsonProperty("moyenneEvaluations")
    private Double moyenneEvaluations;

    @JsonProperty("evaluationFinale")
    private List<EvaluationFinaleDto> evaluationFinale;

    @JsonProperty("imageIllustration")
    private String imageIllustration;

    @JsonProperty("tags")
    private Set<TagDto> tags;



    public static RestaurantDto buildFromEntity(RestaurantEntity restaurantEntity) {
        return RestaurantDto.builder()
                .id(restaurantEntity.getId())
                .nom(restaurantEntity.getNom())
                .adresse(restaurantEntity.getAdresse())
                .evaluations(restaurantEntity.getEvaluations().stream().map(evaluationEntity -> EvaluationDto.fromEntity(evaluationEntity)).toList())
                .evaluationFinale(restaurantEntity.getEvaluationFinaleEntity().stream().map(evaluationFinaleEntity -> EvaluationFinaleDto.fromEntity(evaluationFinaleEntity)).toList())
                .build();
    }
}

