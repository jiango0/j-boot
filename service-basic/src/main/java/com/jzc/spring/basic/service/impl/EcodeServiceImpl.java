package com.jzc.spring.basic.service.impl;

import com.alibaba.fastjson.JSON;
import com.jzc.spring.basic.dao.EcodeGeneratorDao;
import com.jzc.spring.basic.service.EcodeService;
import com.toonyoo.common.ecodegenerator.scan.EcodeGenerator;
import com.toonyoo.common.sequence.domain.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
public class EcodeServiceImpl implements EcodeService {

    @Autowired
    EcodeGenerator ecodeGeneratorServcie;

    @Autowired
    EcodeGeneratorDao ecodeGeneratorDao;

    @PostConstruct
    private void init() {
        ecodeGeneratorServcie.initEcodeGenerator("jzc", 500l, 999999l, 10000l);
    }

    @Transactional
    public String getCode(String name, String codePattern) {
        return ecodeGeneratorServcie.getCode(name, codePattern);
    }

}
