package com.jzc.spring.boot.event.service.impl;

import com.jzc.spring.boot.common.entity.PageList;
import com.jzc.spring.boot.event.dao.ReleaseRepository;
import com.jzc.spring.boot.event.entity.Release;
import com.jzc.spring.boot.event.service.ReleaseService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        qb.should(QueryBuilders.matchQuery("title", search))
                .should(QueryBuilders.matchQuery("content", search));
        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(qb).build();
        Page<Release> result = releaseRepository.search(searchQuery);

        return result.getContent();
    }

    public void delete(Long id) {
        releaseRepository.delete(id);
    }

    public PageList<Release> getPage(String search, Pageable pageable) {
        BoolQueryBuilder qb = QueryBuilders.boolQuery();

        qb.should(QueryBuilders.matchQuery("title", search))
                .should(QueryBuilders.matchQuery("content", search));

        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(qb)
                .withPageable(pageable)
                .build();

//        Page<Release> result = releaseRepository.search(searchQuery.getQuery(), pageable);
        Page<Release> result = elasticsearchTemplate.queryForPage(searchQuery, Release.class);

        return new PageList<Release>(pageable.getPageNumber(), pageable.getPageSize(), result.getContent(), result.getTotalElements());
    }

    public Release detail(Long id) {
//        StringQuery stringQuery = new StringQuery("id="+id);
//        return elasticsearchTemplate.queryForObject(stringQuery, Release.class);

        return releaseRepository.findOne(id);
    }



}
