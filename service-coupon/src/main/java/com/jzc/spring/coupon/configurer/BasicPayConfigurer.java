package com.jzc.spring.coupon.configurer;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

//@Configuration
//@MapperScan(basePackages = "com.jzc.spring.coupon.dao.basicpay", sqlSessionFactoryRef = "basicpaySqlSessionFactory")
public class BasicPayConfigurer {

    @Bean(name = "basicpayDataSource")
    @ConfigurationProperties(prefix = "datasource.basicpay")
    public DataSource basicpayDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "basicpayTransactionManager")
    public DataSourceTransactionManager basicpayTransactionManager(@Qualifier("basicpayDataSource") DataSource basicpayDataSource) {
        return new DataSourceTransactionManager(basicpayDataSource);
    }

    @Bean(name = "basicpaySqlSessionFactory")
    public SqlSessionFactory basicpaySqlSessionFactory(@Qualifier("basicpayDataSource") DataSource basicpayDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(basicpayDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/basicpay/*.xml"));

        return factoryBean.getObject();
    }

}
