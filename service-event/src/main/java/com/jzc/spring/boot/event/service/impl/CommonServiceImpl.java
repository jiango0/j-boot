package com.jzc.spring.boot.event.service.impl;

import com.jzc.spring.boot.event.dao.CommonRepository;
import com.jzc.spring.boot.event.entity.Common;
import com.jzc.spring.boot.event.service.CommonService;
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
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    CommonRepository commonRepository;

    public void batchInfo(List<Common> list) {
        List<IndexQuery> indexQueryList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(list)) {
            list.forEach(common -> {
                IndexQuery indexQuery = new IndexQueryBuilder().withObject(common).build();
                indexQueryList.add(indexQuery);
            });

            elasticsearchTemplate.bulkIndex(indexQueryList);
        }
    }

    public List<Common> getList(String name, Integer age) {
        BoolQueryBuilder qb = new BoolQueryBuilder();
        if(!StringUtils.isEmpty(name)) {
            qb.filter(QueryBuilders.matchPhraseQuery("map.name", name));
        }
        if(age != null) {
            qb.filter(QueryBuilders.termQuery("map.age", age));
        }

        NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(qb).build();

        return elasticsearchTemplate.queryForList(build, Common.class);
    }

}
