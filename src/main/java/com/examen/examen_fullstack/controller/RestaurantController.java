package com.examen.examen_fullstack.controller;

import com.examen.examen_fullstack.dto.RestaurantDto;
import com.examen.examen_fullstack.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController()
public class RestaurantController {
    public final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restoService) {
        this.restaurantService = restoService;
    }

    @GetMapping("/restaurants/{id}")
    public @ResponseBody RestaurantDto getRestaurantById(@PathVariable int id) {
        System.out.println("retourne resto n°" + id);
        return RestaurantDto.buildFromEntity(this.restaurantService.getRestaurantById(id));
    }

    @GetMapping("/restaurants")
    public @ResponseBody List<RestaurantDto> getRestaurants(){
        System.out.println("retourne tous les restos");
        return this.restaurantService.getAllRestaurants().stream().map(entity -> RestaurantDto.buildFromEntity(entity)).collect(Collectors.toList());
    }

    @PostMapping("/restaurants")
    public RestaurantDto postRestaurant(@Valid @RequestBody RestaurantDto resto) {
        System.out.println("j'ai ajouté un resto : " + resto);
        return RestaurantDto.buildFromEntity(this.restaurantService.addRestaurant(resto.getNom(), resto.getAdresse(), resto.getMoyenneEvaluations()));
    }
}
