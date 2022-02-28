package com.noroff.noroffassignment_7.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private Integer id;

    @Getter @Setter
    @Size(min = 1, max = 45)
    @Column(nullable = false)
    private String name;

    @Getter @Setter
    @Size(min = 1, max = 45)
    @Column
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String alias;

    @Getter @Setter
    @Column(nullable = false)
    private Gender gender;

    @Getter @Setter
    @Column
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String imageUrl;

    @Getter @Setter
    @ManyToMany(mappedBy = "characters", fetch = FetchType.LAZY)
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public List<Movie> movies;
}
