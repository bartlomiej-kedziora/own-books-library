package com.akudama.books.domain.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "WORLDSCORE")
public class WorldScore {
    private Long id;
    private int value;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "worldscore_id", unique = true)
    public Long getId() {
        return id;
    }

    public int getValue() {
        return value;
    }
}
