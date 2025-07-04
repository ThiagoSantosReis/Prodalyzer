package com.orders.ordermnagement.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ProductDto(
        @JsonAlias("id") Long id,
        @JsonAlias("title") String name,
        @JsonAlias("price") String price,
        @JsonAlias("description") String description,
        @JsonAlias("category") CategoryDto category
) {

    @Override
    public String toString() {
        return """
                ID: %d - %s
                """.formatted(id, name);
    }
}
