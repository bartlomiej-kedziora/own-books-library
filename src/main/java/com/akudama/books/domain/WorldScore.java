package com.akudama.books.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "WORLDSCORE")
public class WorldScore {
    private Long Id;
    private int value;

    public WorldScore() {
    }

    public WorldScore(int value) {
        this.value = value;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "worldscore_id", unique = true)
    public Long getId() {
        return Id;
    }

    public int getValue() {
        return value;
    }

    private void setId(Long id) {
        Id = id;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
