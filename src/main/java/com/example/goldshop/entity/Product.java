package com.example.goldshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="mehsullar")

public class Product {

    @Id
    @GeneratedValue
    private Integer product_id;
    @Column(name="mehsul_adi")
    private String product_name;
    @Column(name="qiymet")
    private double price;
    @Column(name="karat")
    private Integer carat;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    Category category;


    public Product(int id, String name, double price, int carat) {
    }
}
