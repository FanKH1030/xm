package com.bea.order.service.impl;

import com.bea.order.dao.ProductDao;
import com.bea.order.model.Product;
import com.bea.order.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.addProduct(product);
    }

    @Override
    public void update(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public void delete(String id) {
        productDao.deleteProduct(id);
    }
}
