package com.jzc.spring.boot.event.dao;

import com.jzc.spring.boot.event.entity.Goods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface GoodsRepository extends ElasticsearchRepository<Goods, Long> {
}
