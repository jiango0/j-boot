package com.jzc.spring.boot.event.dao;

import com.jzc.spring.boot.event.entity.Release;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ReleaseRepository extends ElasticsearchRepository<Release, Long> {
}
