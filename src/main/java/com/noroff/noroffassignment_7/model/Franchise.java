package com.noroff.noroffassignment_7.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    @Size(min = 1, max = 45)
    @Column(nullable = false)
    private String name;

    @Getter @Setter
    @Size(min = 1, max = 100)
    @Column
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;

    @Getter @Setter
    @OneToMany(mappedBy = "franchise", fetch = FetchType.LAZY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Movie> movies;
}
