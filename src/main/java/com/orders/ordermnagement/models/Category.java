package com.orders.ordermnagement.models;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @OneToOne(mappedBy = "category")
    private Product product;
    public Category(){}

    public Category(CategoryDto data){
        this.name = data.name();
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId(){return id;}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getName(){return name;}

    public void setName(String name){this.name=name;}

    @Override
    public String toString() {
        return """
                ID: %d
                Name: %s
                """.formatted(id, name);
    }
}
