package com.examen.examen_fullstack.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class EvaluationFinaleEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "decider_name", length = 90)
    private String deciderName;

    @Column(name = "final_stars")
    private int finalStars;

    @Column(name = "descriptive_text", columnDefinition = "TEXT")
    private String descriptiveText;

    @OneToOne()
    @JoinColumn(name = "evaluation_finale_id")
    private RestaurantEntity restaurant;
}
