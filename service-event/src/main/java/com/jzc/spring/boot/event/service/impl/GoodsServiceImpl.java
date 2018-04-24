package com.jzc.spring.boot.event.service.impl;

import com.jzc.spring.boot.event.dao.GoodsRepository;
import com.jzc.spring.boot.event.entity.Goods;
import com.jzc.spring.boot.event.service.GoodsService;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

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
    public List<Goods> getTerm(String spec, String name) {
        BoolQueryBuilder qb = new BoolQueryBuilder();
        if(!StringUtils.isEmpty(spec)) {
            qb.filter(QueryBuilders.termQuery("spec", spec));
        }
        if(!StringUtils.isEmpty(name)) {
            qb.filter(QueryBuilders.termQuery("name", name));
        }

        NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(qb).build();

        return elasticsearchTemplate.queryForList(build, Goods.class);
    }

    /**
     * 全文检索，按照分词的结果进行查询
     * */
    public List<Goods> getMatch(String name) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchQuery("name", name).operator(MatchQueryBuilder.Operator.AND)).build();

        return elasticsearchTemplate.queryForList(searchQuery, Goods.class);
    }

    /**
     * 全文检索，模糊匹配，类似与like的方式
     * */
    public List<Goods> getMatchPhrase(String name) {
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(QueryBuilders.matchPhraseQuery("name", name)).build();

        return elasticsearchTemplate.queryForList(searchQuery, Goods.class);
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

    /**
     * 多字段精确查询
     * */
    public List<Goods> getTerms(Integer[] stockNum) {
        TermsQueryBuilder terms = new TermsQueryBuilder("stockNum", stockNum);
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(terms).build();

        return elasticsearchTemplate.queryForList(searchQuery, Goods.class);
    }

    /**
     * 范围查询
     * */
    public List<Goods> getRange(Integer start, Integer end) {
        RangeQueryBuilder stockNum = new RangeQueryBuilder("stockNum");
        stockNum.gte(start).lte(end);
        NativeSearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(stockNum).build();

        return elasticsearchTemplate.queryForList(searchQuery, Goods.class);
    }



}
