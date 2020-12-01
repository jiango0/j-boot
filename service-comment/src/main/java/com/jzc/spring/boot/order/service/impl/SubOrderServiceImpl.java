package com.jzc.spring.boot.order.service.impl;

import com.jzc.spring.boot.order.dao.SubOrderMongoDao;
import com.jzc.spring.boot.order.dto.SubOrderDTO;
import com.jzc.spring.boot.order.entity.SubOrder;
import com.jzc.spring.boot.order.service.SubOrderService;
import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class SubOrderServiceImpl implements SubOrderService {

    @Autowired
    private SubOrderMongoDao subOrderMongoDao;

    @Override
    public void save(SubOrder subOrder) {
        subOrderMongoDao.getMongoTemplate().insert(subOrder);
    }

    public int update(SubOrderDTO subOrderDTO) {
        Criteria criteria = Criteria.where("parentOrderCode").is(subOrderDTO.getParentOrderCode());
        criteria.and("orderDetailList.tpGoodsSku").is(subOrderDTO.getTpGoodsSku());

        Update update = new Update();
        update.set("orderDetailList.$.purchasePrice", subOrderDTO.getPurchasePrice());
        update.set("orderDetailList.$.settlementPrice", subOrderDTO.getSettlementPrice());

        WriteResult writeResult = subOrderMongoDao.getMongoTemplate().updateMulti(Query.query(criteria), update, SubOrder.class);
        return writeResult.getN();
    }

}
