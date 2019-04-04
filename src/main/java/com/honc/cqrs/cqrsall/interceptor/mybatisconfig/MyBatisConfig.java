package com.honc.cqrs.cqrsall.interceptor.mybatisconfig;

/**
 * @author honc.z
 * @date 2019/4/3
 */

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Configuration
@MapperScan(basePackages = "com.honc.cqrs.cqrsall.mapper.*")
public class MyBatisConfig {
    @Autowired
    private Environment environment;

    /**
     * 手动创建数据源1
     */
    @Bean
    public DataSource queryDataSource() throws Exception {
        Properties props = new Properties();

        props.put("driverClassName", environment.getProperty("queryjdbc.driverClassName"));
        props.put("url", environment.getProperty("queryjdbc.url"));
        props.put("username", environment.getProperty("queryjdbc.username"));
        props.put("password", environment.getProperty("queryjdbc.password"));

        return DruidDataSourceFactory.createDataSource(props);
    }

    /**
     * 手动创建数据源2
     */
    @Bean
    public DataSource commandDataSource() throws Exception {

        Properties props = new Properties();

        props.put("driverClassName", environment.getProperty("commandjdbc.driverClassName"));
        props.put("url", environment.getProperty("commandjdbc.url"));
        props.put("username", environment.getProperty("commandjdbc.username"));
        props.put("password", environment.getProperty("commandjdbc.password"));

        return DruidDataSourceFactory.createDataSource(props);
    }

    /**
     * @Primary 该注解表示在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@autowire注解报错
     * @Qualifier 根据名称进行注入，通常是在具有相同的多个类型的实例的一个注入（例如有多个DataSource类型的实例）
     */
    @Bean
    @Primary
    @DependsOn({ "queryDataSource", "commandDataSource"})
    public DynamicDataSource dataSource(@Qualifier("queryDataSource") DataSource queryDataSource,
                                        @Qualifier("commandDataSource") DataSource commandDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DatabaseType.querydb, queryDataSource);
        targetDataSources.put(DatabaseType.commanddb, commandDataSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources);// 该方法是AbstractRoutingDataSource的方法
        // 默认的datasource设置为myTestDbDataSource
        dataSource.setDefaultTargetDataSource(queryDataSource);

        return dataSource;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("queryDataSource") DataSource queryDataSource,
                                               @Qualifier("commandDataSource") DataSource commandDataSource) throws Exception {
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(this.dataSource(queryDataSource(), commandDataSource()));// 指定数据源(这个必须有，否则报错)
        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
//        fb.setTypeAliasesPackage(env.getProperty("mybatis.typeAliasesPackage"));// 指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(environment.getProperty("mybatis.mapper-locations")));

        return fb.getObject();
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}
