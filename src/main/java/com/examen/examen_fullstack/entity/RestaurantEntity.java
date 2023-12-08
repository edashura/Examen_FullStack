package com.examen.examen_fullstack.entity;

import com.examen.examen_fullstack.dto.EvaluationDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RestaurantEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "nom", length = 90, columnDefinition = "VARCHAR(90)")
    private String nom;

    @Column(name = "adresse", length = 255, columnDefinition = "VARCHAR(255)")
    private String adresse;

    @Column(name = "moyenne_evaluations", columnDefinition = "DOUBLE DEFAULT 0.0")
    private Double moyenneEvaluations;

    @OneToMany(mappedBy = "restaurant")
    private List<EvaluationEntity> evaluations;


    @OneToOne
    @JoinColumn(name = "evaluation_finale_id")
    private EvaluationFinaleEntity evaluationFinale;


    @OneToMany(mappedBy ="restaurant")
    private List<EvaluationEntity> evaluationEntity;

    @OneToMany(mappedBy ="restaurant")
    private List<EvaluationFinaleEntity> evaluationFinaleEntity;



    @ManyToMany
    @JoinTable(name = "restaurant_tags",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<TagEntity> tags;





}
