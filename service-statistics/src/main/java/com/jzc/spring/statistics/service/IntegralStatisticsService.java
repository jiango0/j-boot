package com.jzc.spring.statistics.service;

import com.jzc.spring.statistics.model.IntegralStatistics;
import com.jzc.spring.statistics.param.IntegralStatisticsForm;

import java.util.List;

public interface IntegralStatisticsService {

    void save(IntegralStatistics statistics);

    void batchSave(List<IntegralStatistics> list);

    List<IntegralStatistics> list(IntegralStatisticsForm statistics);

}
