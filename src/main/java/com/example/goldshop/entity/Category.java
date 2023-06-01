package com.example.goldshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="kateqoriyalar")
public class Category {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "ad")
    private String name;

//    @OneToMany(mappedBy = "category")
//    List<Category> categories;

}
