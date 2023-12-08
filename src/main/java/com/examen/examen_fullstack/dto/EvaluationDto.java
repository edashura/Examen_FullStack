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

        @JsonProperty("nomEvaluateur")
        @Size(max = 50)
        private String nomEvaluateur;

        @JsonProperty("commentaire")
        @Size(max = 255)
        private String commentaire;

        @JsonProperty("note")
        private int note;


        public static EvaluationDto fromEntity(EvaluationEntity evaluationEntity) {
            return EvaluationDto.builder()
                    .id(evaluationEntity.getId())
                    .nomEvaluateur(evaluationEntity.getEvaluateurName())
                    .commentaire(evaluationEntity.getCommentaire())
                    .note(evaluationEntity.getEtoile())
                    .build();
        }
    }
