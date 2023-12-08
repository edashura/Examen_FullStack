package com.examen.examen_fullstack.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EvaluationEntity {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "evaluateur_name", length = 50)
    private String evaluateurName;

    @Column(name = "commentaire", length = 255)
    private String commentaire;

    @Column(name = "etoile")
    private int etoile;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @ManyToOne()
    @JoinColumn(name = "restaurant")
    private RestaurantEntity restaurant;
    //@OneToMany(mappedBy = "evaluation", cascade = CascadeType.ALL)
    //private List<PhotoEntity> photos;

}
