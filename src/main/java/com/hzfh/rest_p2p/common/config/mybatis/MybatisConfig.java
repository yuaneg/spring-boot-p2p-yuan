package com.hzfh.rest_p2p.common.config.mybatis;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.github.pagehelper.PageHelper;

/**
 * Created by paul on 16/7/23.
 */
@Configuration
@EnableTransactionManagement
@MapperScan(basePackages = "com.hzfh.rest_p2p.*.mapper")
public class MybatisConfig implements EnvironmentAware {
       
    private Environment env;
    
    @Override
    public void setEnvironment(Environment environment) {      
        this.env = environment;
    }

    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", env.getProperty("pageHelper.offsetAsPageNum"));
        p.setProperty("rowBoundsWithCount", env.getProperty("pageHelper.rowBoundsWithCount"));
        p.setProperty("reasonable", env.getProperty("pageHelper.reasonable"));
        pageHelper.setProperties(p);
        return pageHelper;
    }
          
    /**
     * 创建数据源
     *
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     */
    @Bean(name="DataSource")
    public DataSource getDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("db.driverClassName"));
        props.put("url", env.getProperty("db.url"));
        props.put("username", env.getProperty("db.username"));
        props.put("password", env.getProperty("db.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }
    
    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(PageHelper pageHelper,@Qualifier("DataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setPlugins(new Interceptor[]{pageHelper});
        fb.setDataSource(dataSource);//指定数据源(这个必须有，否则报错)
        fb.setTypeAliasesPackage(env.getProperty("db.typeAliasesPackage"));//指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("db.mybatisConfigLocation")));//指定xml文件位置
        return fb.getObject();
    }
    
    
    @Bean
    public SqlSessionTemplate SqlSessionTemplate(@Qualifier("SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    
    @Bean
    public DataSourceTransactionManager TransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}