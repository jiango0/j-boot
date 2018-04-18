package com.jzc.spring.boot.event.service.impl;

import com.jzc.spring.boot.event.dao.ReleaseRepository;
import com.jzc.spring.boot.event.entity.Release;
import com.jzc.spring.boot.event.service.ReleaseService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReleaseServiceImpl implements ReleaseService {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    ReleaseRepository releaseRepository;

    public void save(Release release) {
        releaseRepository.save(release);
    }

    public List<Release> singleList(String search) {
        BoolQueryBuilder qb = QueryBuilders.boolQuery();
        qb.must(QueryBuilders.matchQuery("title", search))
                .should(QueryBuilders.matchQuery("content", search));
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(qb).build();
        Page<Release> result = releaseRepository.search(searchQuery);

        return result.getContent();
    }

}
