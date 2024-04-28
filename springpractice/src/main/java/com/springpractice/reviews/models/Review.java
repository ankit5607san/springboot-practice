package com.springpractice.reviews.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springpractice.companies.models.Company;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_review")
public class Review
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private Float rating;

    @JsonIgnore
    @ManyToOne
    private Company company;
}
