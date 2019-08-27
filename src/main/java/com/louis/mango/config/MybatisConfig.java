package com.louis.mango.config;

import java.io.IOException;

import javax.activation.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.*;

@Configuration
@MapperScan("com.louis.mango.**.dao")
public class MybatisConfig {
	@Autowired
	private javax.sql.DataSource dataSource;
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setTypeAliasesPackage("com.louis.mango.**.model");
		PathMatchingResourcePatternResolver resolver = 
				new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources("classpath*:**/sqlmap/*.xml"));
		return sessionFactory.getObject();
	}
}




