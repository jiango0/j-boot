package com.jzc.spring.boot.event.service;

import com.jzc.spring.boot.common.entity.PageList;
import com.jzc.spring.boot.event.entity.Release;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReleaseService {

    void save(Release release);

    List<Release> singleList(String search);

    PageList<Release> getPage(String search, Pageable pageable);

    Release detail(Long id);

}
