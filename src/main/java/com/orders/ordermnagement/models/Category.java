package com.orders.ordermnagement.models;

public class Category {
    private Long id;
    private String name;

    public Category(){}

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
