package com.jzc.spring.boot.event.service;

import com.jzc.spring.boot.event.entity.Goods;

import java.util.List;

public interface GoodsService {

    void batchGoods(List<Goods> goodsList);

    List<Goods> getTerm(String spec);

    List<Goods> getMatch(String name);

    List<Goods> getMatchPhrase(String name);

    List<Goods> getBoolQuery(String name, Integer stockNum, String spec);

    List<Goods> getTerms(Integer[] stockNum);

    List<Goods> getRange(Integer start, Integer end);

}
