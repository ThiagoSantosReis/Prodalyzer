package com.orders.ordermnagement.services;

public interface IConverter {
    <T> T getData(String json, Class<T> cls);
}
