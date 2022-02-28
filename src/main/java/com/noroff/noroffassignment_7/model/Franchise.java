package com.noroff.noroffassignment_7.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column
    @Size(min = 1, max = 45)
    @Getter
    @Setter
    private String name;

    @Column
    @Size(min = 1, max = 100)
    @Getter
    @Setter
    private String description;

    /*@OneToMany(mappedBy = "franchise", fetch = FetchType.LAZY)
    private List<Movie> movies;*/
}
