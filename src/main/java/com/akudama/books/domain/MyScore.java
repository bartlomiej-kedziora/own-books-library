package com.akudama.books.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "myscore")
public class MyScore {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private int value;
}
