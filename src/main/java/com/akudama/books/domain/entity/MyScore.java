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
@Table(name = "MYSCORE")
public class MyScore {
    private Long id;
    private int value;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "myscore_id", unique = true)
    public Long getId() {
        return id;
    }

    public int getValue() {
        return value;
    }
}
