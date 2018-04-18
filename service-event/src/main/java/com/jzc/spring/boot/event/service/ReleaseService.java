package com.jzc.spring.boot.event.service;

import com.jzc.spring.boot.event.entity.Release;

import java.util.List;

public interface ReleaseService {

    void save(Release release);

    List<Release> singleList(String search);

}
