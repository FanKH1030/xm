package com.bea.order.dao;

import com.bea.order.model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Repository
public interface ProductDao {

    List<Product> findAll() throws Exception;

    Product findById(String id) throws Exception;

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(String id);
}
