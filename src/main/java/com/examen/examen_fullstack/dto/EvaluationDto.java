package com.examen.examen_fullstack.dto;

import com.examen.examen_fullstack.entity.EvaluationEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

 public class EvaluationDto {

        @JsonProperty("id")
        private int id;

        @JsonProperty("evaluateur_name")
        @Size(max = 50)
        private String evaluateurName;

        @JsonProperty("commentaire")
        @Size(max = 255)
        private String commentaire;

        @JsonProperty("etoile")
        private int etoile;


        public static EvaluationDto fromEntity(EvaluationEntity evaluationEntity) {
            return EvaluationDto.builder()
                    .id(evaluationEntity.getId())
                    .evaluateurName(evaluationEntity.getEvaluateurName())
                    .commentaire(evaluationEntity.getCommentaire())
                    .etoile(evaluationEntity.getEtoile())
                    .build();
        }
    }
