package com.bea.order.service;

import com.bea.order.model.Orders;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
public interface OrdersService {

    List<Orders> findAll(Integer pageNum,Integer pageSize) throws Exception;

    Orders findById(String ordersId) throws Exception;
}
