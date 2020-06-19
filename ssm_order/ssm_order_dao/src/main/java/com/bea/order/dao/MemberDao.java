package com.bea.order.dao;

import com.bea.order.model.Member;
import org.springframework.stereotype.Repository;

/**
 * Created by fandi on 2020/5/11 0011.
 */
@Repository
public interface MemberDao {

    Member findById(String id) throws Exception;

}
