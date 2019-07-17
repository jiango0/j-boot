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
//@MapperScan(basePackages = "com.jzc.spring.coupon.dao.member", sqlSessionFactoryRef = "memberSqlSessionFactory")
public class MemberManagementConfigurer {

    @Bean(name = "memberDataSource")
    @ConfigurationProperties(prefix = "datasource.member")
    public DataSource memberDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "memberTransactionManager")
    public DataSourceTransactionManager memberTransactionManager(@Qualifier("memberDataSource") DataSource memberDataSource) {
        return new DataSourceTransactionManager(memberDataSource);
    }

    @Bean(name = "memberSqlSessionFactory")
    public SqlSessionFactory memberSqlSessionFactory(@Qualifier("memberDataSource") DataSource memberDataSource) throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(memberDataSource);
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver.getResources("classpath:mapper/member/*.xml"));

        return factoryBean.getObject();
    }

}
