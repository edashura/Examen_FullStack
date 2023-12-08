package com.examen.examen_fullstack.controller;

import com.examen.examen_fullstack.dto.EvaluationDto;
import com.examen.examen_fullstack.service.EvaluationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class EvaluationController {
    private final EvaluationService evaluationService;

    @GetMapping("/restaurants/{id}/evaluations")
    public @ResponseBody List<EvaluationDto> getEvaluations(){
        System.out.println("retourne les evaluations d'un resto");
        return this.evaluationService.getAllEvaluations().stream().map(entity -> EvaluationDto.fromEntity(entity)).collect(Collectors.toList());
    }

    @PostMapping("restaurants/{restaurantId}/evaluations")
    public @ResponseBody EvaluationDto addEvaluation(@Valid @RequestBody EvaluationDto dto, @PathVariable int restaurantId) {
        System.out.println("ajout evaluation à resto n°" + restaurantId);
        return EvaluationDto.fromEntity(this.evaluationService.addEvaluation(restaurantId, dto.getCommentaire(), dto.getEvaluateurName(), dto.getEtoile()));
    }
}
