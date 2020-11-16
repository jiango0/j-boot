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

@Configuration
@MapperScan(basePackages = "com.jzc.spring.coupon.dao.message", sqlSessionFactoryRef = "messageSqlSessionFactory")
public class MessageConfgurer {

    @Bean(name = "messageDataSource")
    @ConfigurationProperties(prefix = "datasource.message")
    public DataSource messageDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "messageTransactionManager")
    public DataSourceTransactionManager messageTransactionManager(@Qualifier("messageDataSource") DataSource messageDataSource) {
        return new DataSourceTransactionManager(messageDataSource);
    }

    @Bean(name = "messageSqlSessionFactory")
    public SqlSessionFactory messageSqlSessionFactory(@Qualifier("messageDataSource") DataSource messageDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(messageDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/message/*.xml"));

        return factoryBean.getObject();
    }

}
