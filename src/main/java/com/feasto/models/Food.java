package com.feasto.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Length;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToOne
    @JsonIgnore
    private Restaurant restaurant;

    private String description;
    private Long price;

    @ManyToOne   //many food item will lie ion the same category of food
    private Category foodCategory;

    @Column(length = 1000) //thats why we need to give length for url
    @ElementCollection
    private List<String> images; //we will store these images in cloudinary

    private boolean available;
    private boolean isVegetarian;
    private boolean isSeasonal;

    @ManyToMany         //many food items can be made from multiple ingredients
    private List<IngredientsItem> ingredients = new ArrayList<>();

    private Date creationDate ;
}
