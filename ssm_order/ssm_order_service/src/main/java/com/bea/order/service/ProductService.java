package com.bea.order.service;

import com.bea.order.model.Product;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
public interface ProductService {

    List<Product> findAll() throws Exception;

    void save(Product product);

    void update(Product product);

    void delete(String id);
}
