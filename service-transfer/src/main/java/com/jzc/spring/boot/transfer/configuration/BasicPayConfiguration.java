package com.jzc.spring.boot.transfer.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.jzc.spring.boot.transfer.dao.basicpay", sqlSessionFactoryRef = "basicPaySqlSessionFactory")
public class BasicPayConfiguration {

    @Primary
    @Bean(name = "basicPayDataSource")
    @ConfigurationProperties(prefix = "datasource.basic.pay")
    public DataSource basicPayDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "basicPayTransactionManager")
    public DataSourceTransactionManager basicPayTransactionManager(@Qualifier("basicPayDataSource") DataSource basicPayDataSource) {
        return new DataSourceTransactionManager(basicPayDataSource);
    }

    @Primary
    @Bean(name = "basicPaySqlSessionFactory")
    public SqlSessionFactory basicPaySqlSessionFactory(@Qualifier("basicPayDataSource") DataSource basicPayDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(basicPayDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/basicpay/*.xml"));

        return factoryBean.getObject();
    }

}
