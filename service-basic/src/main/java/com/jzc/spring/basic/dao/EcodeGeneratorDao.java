package com.jzc.spring.basic.dao;

import com.jzc.spring.boot.common.dao.mongo.AbstractBaseMongoDao;
import com.toonyoo.common.sequence.domain.Sequence;
import org.springframework.stereotype.Component;

@Component
public class EcodeGeneratorDao extends AbstractBaseMongoDao<Sequence, String> {
}
