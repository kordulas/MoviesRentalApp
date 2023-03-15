package com.movielibrary.demo.director.api;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "Directors")
@Getter
@Setter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long directorId;
    private String firstName;
    private String lastName;
}
