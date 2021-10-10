package com.multipledatasourceswithspringbootdatajpa.api.configuration;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.multipledatasourceswithspringbootdatajpa.api.repository.order"
        ,entityManagerFactoryRef = "orderEntityManagerFactory"
        ,transactionManagerRef ="orderTransactionManager"
)
public class OrderDataSourceConfiguration {

    @Bean
    @ConfigurationProperties("spring.datasource.order")
    public DataSourceProperties orderDataSourceProperties(){
        return new DataSourceProperties();
    }
    @Bean
    @ConfigurationProperties("spring.datasource.order.configuration")
    public DataSource orderDataSource(){
        return orderDataSourceProperties().initializeDataSourceBuilder()
                .type(HikariDataSource.class).build();
    }

    @Bean(name = "orderEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean orderEntityManagerFactory(
            EntityManagerFactoryBuilder builder){
        return builder
                .dataSource(orderDataSource())
                .packages("com.multipledatasourceswithspringbootdatajpa.api.model.order")
                .build();
    }

    @Bean
    public PlatformTransactionManager orderTransactionManager(
            final @Qualifier("orderEntityManagerFactory") LocalContainerEntityManagerFactoryBean orderEntityManagerFactory){
        return new JpaTransactionManager(orderEntityManagerFactory.getObject());

    }


}
