package com.orders.ordermnagement.services;

import com.fasterxml.jackson.core.type.TypeReference;

public interface IConverter {
    <T> T getData(String json, Class<T> cls);

    <T> T getDataList(String json, TypeReference<T> typeRef);
}
