package com.mjmspred.config;

import com.zaxxer.hikari.HikariDataSource;
import lombok.Data;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.support.JdbcTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;

/**
 * @author : chunf
 */
//@Configuration
@EnableConfigurationProperties({MealDataSourceConfig.MealDataSourceProperties.class, MealDataSourceConfig.MealMybatisProperties.class})
@MapperScan(basePackages = MealDataSourceConfig.BASE_MAPPER_PACKAGES, sqlSessionTemplateRef = MealDataSourceConfig.SESSION_TEMP_NAME)
public class MealDataSourceConfig {
    public static final String TRANSACTION_BEAN_NAME = "mealTransactionManager";
    private static final String DATASOURCE_BEAN_NAME = "mealDataSource";
    public static final String BASE_MAPPER_PACKAGES = "com.mjmspred.mapper.meal";
    public static final String SESSION_TEMP_NAME = "mealSqlSessionTemplate";
    private static final String SESSION_FACTORY_NAME = "mealSqlSessionFactory";
    private static final String DATASOURCE_PROPS_PREFIX = "spring.datasource.meal";
    private static final String MYBATIS_PROPS_PREFIX = "mybatis.meal";
    private final ResourceLoader resourceLoader;
    private final MealMybatisProperties properties;

    public MealDataSourceConfig(ResourceLoader resourceLoader, MealMybatisProperties properties) {
        this.resourceLoader = resourceLoader;
        this.properties = properties;
    }

    @Data
    @ConfigurationProperties(prefix = DATASOURCE_PROPS_PREFIX)
    protected static class MealDataSourceProperties {
        private String driverClassName;
        private String username;
        private String password;
        private String url;
    }

    @ConfigurationProperties(prefix = MYBATIS_PROPS_PREFIX)
    static class MealMybatisProperties extends MybatisProperties {

    }

    @Bean
    public TransactionManager mealTransactionManager(@Qualifier(DATASOURCE_BEAN_NAME) DataSource dataSource) {
        return new JdbcTransactionManager(dataSource);
    }

    @Bean
    DataSource mealDataSource(MealDataSourceProperties properties) {
        HikariDataSource source = new HikariDataSource();
        source.setDriverClassName(properties.driverClassName);
        source.setUsername(properties.username);
        source.setPassword(properties.password);
        source.setJdbcUrl(properties.url);
        return source;
    }

    @Bean
    public SqlSessionFactory mealSqlSessionFactory(@Qualifier(DATASOURCE_BEAN_NAME) DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setVfs(SpringBootVFS.class);
        if (StringUtils.hasText(this.properties.getConfigLocation())) {
            factory.setConfigLocation(this.resourceLoader.getResource(this.properties.getConfigLocation()));
        }
        if (this.properties.getConfigurationProperties() != null) {
            factory.setConfigurationProperties(this.properties.getConfigurationProperties());
        }
        /* 代替applyConfiguration */
        factory.setConfiguration(new org.apache.ibatis.session.Configuration());

        if (StringUtils.hasLength(this.properties.getTypeAliasesPackage())) {
            factory.setTypeAliasesPackage(this.properties.getTypeAliasesPackage());
        }
        if (this.properties.getTypeAliasesSuperType() != null) {
            factory.setTypeAliasesSuperType(this.properties.getTypeAliasesSuperType());
        }
        if (StringUtils.hasLength(this.properties.getTypeHandlersPackage())) {
            factory.setTypeHandlersPackage(this.properties.getTypeHandlersPackage());
        }
        Resource[] mapperLocations = this.properties.resolveMapperLocations();
        if (!ObjectUtils.isEmpty(mapperLocations)) {
            factory.setMapperLocations(mapperLocations);
        }
        return factory.getObject();
    }

    @Bean
    public SqlSessionTemplate mealSqlSessionTemplate(@Qualifier(SESSION_FACTORY_NAME) SqlSessionFactory sqlSessionFactory) {
        ExecutorType executorType = this.properties.getExecutorType();
        if (executorType != null) {
            return new SqlSessionTemplate(sqlSessionFactory, executorType);
        } else {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }

}
