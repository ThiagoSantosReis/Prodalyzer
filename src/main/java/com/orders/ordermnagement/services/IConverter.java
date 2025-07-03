package com.orders.ordermnagement.services;

import aj.org.objectweb.asm.TypeReference;

public interface IConverter {
    <T> T getData(String json, Class<T> cls);
}
