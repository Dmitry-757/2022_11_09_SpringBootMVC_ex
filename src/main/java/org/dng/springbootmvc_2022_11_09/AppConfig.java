package org.dng.springbootmvc_2022_11_09;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import javax.sql.DataSource;


@Configuration
//@PropertySource("classpath:application.properties")
public class AppConfig {
    @Bean
    public DataSource dataSource() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/students");
//        properties.setProperty("hibernate.connection.username", "root");
//        properties.setProperty("hibernate.connection.password", "dingo1975");
//        properties.setProperty("dialect", "org.hibernate.dialect.MySQLDialect");
//        properties.setProperty("hibernate.hbm2ddl.auto", "create");

//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUsername("root");
//        dataSource.setPassword("dingo1975");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/students_db?createDatabaseIfNotExist=true");
//        return dataSource;

        return DataSourceBuilder
                .create()
                .username("root")
                .password("dingo1975")
                .url("jdbc:mysql://localhost:3306/students_db?createDatabaseIfNotExist=true")
//                .url("jdbc:mysql://localhost:3306/students_db")
                .driverClassName("com.mysql.cj.jdbc.Driver")
                .build();
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        hibernateJpaVendorAdapter.setShowSql(true);
        hibernateJpaVendorAdapter.setGenerateDdl(true);
        hibernateJpaVendorAdapter.setDatabase(Database.MYSQL);
        return hibernateJpaVendorAdapter;
    }


//    @Bean(name = "entityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        final LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
//        entityManagerFactoryBean.setDataSource(dataSource());
//        entityManagerFactoryBean.setJpaVendorAdapter(jpaVendorAdapter());
//        entityManagerFactoryBean.setPackagesToScan("org.dng.springbootmvc_2022_11_09");
//
//        final Properties hibernateProperties = new Properties();
//        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
//        hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        hibernateProperties.setProperty("hibernate.show_sql", "true");
//        entityManagerFactoryBean.setJpaProperties(hibernateProperties);
//
//        return entityManagerFactoryBean;
//    }

//    @Bean
//    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
//        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//        factory.setJpaVendorAdapter(jpaVendorAdapter());
//        factory.setPackagesToScan("org.dng.springbootmvc_2022_11_09");
//        factory.setDataSource(dataSource());
//        factory.setJpaPropertyMap(new HashMap<String, Object>() {{
//            put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//            put("hibernate.hbm2ddl.auto", "create");
//        }});
//        factory.afterPropertiesSet();
//        return factory;
//    }
//    @Bean
//    public PlatformTransactionManager transactionManager() {
//        JpaTransactionManager transactionManager = new JpaTransactionManager();
//        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
//        return transactionManager;
//    }
}
