package com.examen.examen_fullstack.controller;

import com.examen.examen_fullstack.dto.EvaluationDto;
import com.examen.examen_fullstack.dto.EvaluationFinaleDto;
import com.examen.examen_fullstack.service.EvaluationFinaleService;
import com.examen.examen_fullstack.service.EvaluationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class EvaluationFinaleController {
    private final EvaluationFinaleService evaluationFinaleService;

    @GetMapping("/restaurants/{id}/evaluationfinale")
    public @ResponseBody List<EvaluationFinaleDto> getEvaluations(){
        return this.evaluationFinaleService.getEvaluationFinale().stream().map(entity -> EvaluationFinaleDto.fromEntity(entity)).collect(Collectors.toList());
    }

    @PostMapping("restaurants/{restaurantId}/evaluationfinale")
    public @ResponseBody EvaluationFinaleDto addEvaluation(@Valid @RequestBody EvaluationFinaleDto dto, @PathVariable int restaurantId) {
        return EvaluationFinaleDto.fromEntity(this.evaluationFinaleService.addEvaluationFinale(restaurantId, dto.getDecideurName(), dto.getFinalNote(), dto.getDescriptiveText()));
    }
}
