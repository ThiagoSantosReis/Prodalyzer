package com.orders.ordermnagement.models;

public record ProductDto(
        Long id,
        String name,
        String price,
        String description
) {

    @Override
    public String toString() {
        return """
                ID: %d - %s
                """.formatted(id, name);
    }
}
