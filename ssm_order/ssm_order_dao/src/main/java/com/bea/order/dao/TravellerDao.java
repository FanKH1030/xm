package com.bea.order.dao;

import com.bea.order.model.Traveller;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Repository
public interface TravellerDao {

    List<Traveller> findByOrdersId(String ordersId) throws Exception;

}
