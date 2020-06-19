package com.bea.order.dao;

import com.bea.order.model.Orders;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Repository
public interface OrdersDao {

    List<Orders> findAll() throws Exception;

    Orders findById(String id);
}
