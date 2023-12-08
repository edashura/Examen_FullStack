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

    @Column(name = "nom", length = 90)
    private String nom;

    @Column(name = "adresse", length = 255)
    private String adresse;

    @OneToMany(mappedBy = "restaurant")
    private List<EvaluationEntity> evaluations;

    @Column(name = "moyenne_evaluations")
    private Double moyenneEvaluations;

    @OneToOne
    @JoinColumn(name = "evaluation_finale_id")
    private EvaluationFinaleEntity evaluationFinale;

    @Column(name = "image_illustration")
    private String imageIllustration;

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
