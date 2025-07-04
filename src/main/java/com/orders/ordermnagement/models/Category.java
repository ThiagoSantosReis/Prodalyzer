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

    public Category(){}

    public Category(CategoryDto data){
        this.name = data.name();
    }

    public Long getId(){return id;}

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
