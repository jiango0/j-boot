package com.jzc.spring.boot.transfer.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.jzc.spring.boot.transfer.dao.pay", sqlSessionFactoryRef = "paySqlSessionFactory")
public class PayConfiguration {

    @Bean(name = "payDataSource")
    @ConfigurationProperties(prefix = "datasource.pay")
    public DataSource payDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "payTransactionManager")
    public DataSourceTransactionManager payTransactionManager(@Qualifier("payDataSource") DataSource payDataSource) {
        return new DataSourceTransactionManager(payDataSource);
    }

    @Bean(name = "paySqlSessionFactory")
    public SqlSessionFactory paySqlSessionFactory(@Qualifier("payDataSource") DataSource payDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(payDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/pay/*.xml"));

        return factoryBean.getObject();
    }

}
