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

public class TagEntity {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "tag_name")
    @Enumerated(EnumType.STRING)
    private TagName tagName;

    public enum TagName {
        Gastronomique,
        Bistrot,
        Bistronomique,
        Brasserie,
        Fastfood
    }
}
