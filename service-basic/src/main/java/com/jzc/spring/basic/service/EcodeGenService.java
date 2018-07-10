package com.jzc.spring.basic.service;

public interface EcodeGenService {

    String getCode(String name, int randomSize, int seqSize, int seqFetchSize);

}
