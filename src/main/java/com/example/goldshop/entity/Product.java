package com.example.goldshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name="mehsullar")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;
    @Column(name="mehsul_adi")
    private String name;
    @Column(name="qiymet")
    private Double price;
    @Column(name="karat")
    private Integer carat;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    Category category;


    public Product(int id, String name, double price, int carat) {
    }
}
