package com.jzc.spring.boot.event.service.impl;

import com.jzc.spring.boot.event.dao.GoodsRepository;
import com.jzc.spring.boot.event.entity.Goods;
import com.jzc.spring.boot.event.service.GoodsService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    GoodsRepository goodsRepository;

    public void batchGoods(List<Goods> goodsList) {
        List<IndexQuery> indexQueryList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(goodsList)) {
            goodsList.forEach(goods -> {
                goods.setId((long) ((Math.random() * 9 + 1) * 100000000000L));
                IndexQuery indexQuery = new IndexQueryBuilder().withObject(goods).build();
                indexQueryList.add(indexQuery);
            });

            elasticsearchTemplate.bulkIndex(indexQueryList);
        }
    }

    /**
     * 精确值查询
     * term 完全匹配才能查询出来
     * 会跟据分词进行查询，如果需要全字段配置就将field设置不分词
     * */
    public List<Goods> getTerm(String spec) {
        BoolQueryBuilder qb = new BoolQueryBuilder();
        qb.filter(QueryBuilders.termQuery("spec", spec));
        NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(qb).build();

        return elasticsearchTemplate.queryForList(build, Goods.class);
    }

    /**
     * 组合查询
     * */
    public List<Goods> getBoolQuery(String name, Integer stockNum, String spec) {
        BoolQueryBuilder qb = new BoolQueryBuilder();

        qb.should(QueryBuilders.matchQuery("name", name))
                .should(new BoolQueryBuilder()
                        .must(QueryBuilders.termQuery("stockNum", stockNum))
                        .must(QueryBuilders.termQuery("spec", spec)));

        NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(qb).build();

        return elasticsearchTemplate.queryForList(build, Goods.class);
    }



}
