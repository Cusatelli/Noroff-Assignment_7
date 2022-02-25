package com.noroff.noroffassignment_7.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Size(min = 1, max = 45)
    private String name;

    @Column
    @Size(min = 1, max = 45)
    private String alias;

    @Column
    private Gender gender;

    @Column
    private String imageUrl;

    /*@ManyToMany(mappedBy = "movies_id", fetch = FetchType.LAZY)
    public List<Movie> movies;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
