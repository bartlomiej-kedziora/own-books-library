package com.akudama.books.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "WORLDSCORE")
public class WorldScore {
    private Long Id;
    private int value;

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
