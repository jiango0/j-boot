package com.jzc.spring.boot.event.service;

import com.jzc.spring.boot.event.entity.Common;

import java.util.List;
import java.util.Map;

public interface CommonService {

    void batchInfo(List<Common> list);

    List<Common> getList(String name, Integer age);

}
