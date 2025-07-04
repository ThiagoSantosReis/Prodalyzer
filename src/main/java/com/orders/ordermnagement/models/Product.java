package com.orders.ordermnagement.models;

import jakarta.persistence.*;

import java.util.OptionalDouble;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String title;
    private Double price;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Product(){}

    public Product(ProductDto data) {
        this.title = data.name();
        this.price = OptionalDouble.of(Double.parseDouble(data.price())).orElse(0.0);
        this.category = new Category(data.category());
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public String toString(){
        return """
                ID: %d
                Title: %s
                $%.2f
                Category: %s
                """.formatted(id, title, price, category.getName());
    }

}
