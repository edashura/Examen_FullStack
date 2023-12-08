package com.examen.examen_fullstack.dto;

import com.examen.examen_fullstack.entity.EvaluationEntity;
import com.examen.examen_fullstack.entity.EvaluationFinaleEntity;
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
public class EvaluationFinaleDto {
    @JsonProperty("id")
    private int id;

    @JsonProperty("decideurName")
    @Size(max = 90)
    private String decideurName;

    @JsonProperty("finalNote")
    private int finalNote;

    @JsonProperty("descriptiveText")
    private String descriptiveText;


    public static EvaluationFinaleDto fromEntity(EvaluationFinaleEntity evaluationFinaleEntity) {
        return EvaluationFinaleDto.builder()
                .id(evaluationFinaleEntity.getId())
                .decideurName(evaluationFinaleEntity.getDeciderName())
                .finalNote(evaluationFinaleEntity.getFinalStars())
                .descriptiveText(evaluationFinaleEntity.getDescriptiveText())
                .build();
    }
}
