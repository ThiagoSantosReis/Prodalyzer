package com.orders.ordermnagement.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CategoryDto(
        @JsonAlias("id") Long id,
        @JsonAlias("name") String name
) {
    private String getName(){
        return name;
    }
    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
