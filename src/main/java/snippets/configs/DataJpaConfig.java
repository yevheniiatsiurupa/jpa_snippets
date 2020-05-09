package snippets.configs;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableSpringDataWebSupport
@ComponentScan(basePackages = "snippets.entity")
@EnableJpaRepositories(basePackages = "snippets.dao")
@PropertySource("classpath:/props/db.properties")
public class DataJpaConfig {

    @Autowired
    Environment env;


    @Bean(destroyMethod = "close")
    public BasicDataSource dataSource() {
        String systemDbUrl = System.getenv("JDBC_DATABASE_URL");
        String systemUsername = System.getenv("JDBC_DATABASE_USERNAME");
        String systemPassword = System.getenv("JDBC_DATABASE_PASSWORD");

        String dbUrl = systemDbUrl == null ? env.getProperty("url") : systemDbUrl;
        String username = systemUsername == null ? env.getProperty("db.username") : systemUsername;
        String password = systemPassword == null ? env.getProperty("password") : systemPassword;

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl(dbUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JpaVendorAdapter jpaVendorAdapter() {
        return new HibernateJpaVendorAdapter();
    }

    @Bean
    public Properties hibernateProperties() {
        Properties hibernateProp = new Properties();
        hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        hibernateProp.put("hibernate.use_sql_comments", true);
        hibernateProp.put("hibernate.format_sql", true);
        hibernateProp.put("hibernate.max_fetch_depth", 3);
        hibernateProp.put("hibernate.batch_size", 10);
        hibernateProp.put("hibernate.fetch_size", 50);
        hibernateProp.put("hibernate.jdbc.batch_size", "5");
        return hibernateProp;
    }

    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean =
                new LocalContainerEntityManagerFactoryBean();
        factoryBean.setPackagesToScan("snippets.entity");
        factoryBean.setDataSource(dataSource());
        factoryBean.setJpaVendorAdapter(jpaVendorAdapter());
        factoryBean.setJpaProperties(hibernateProperties());
        factoryBean.afterPropertiesSet();
        return factoryBean.getNativeEntityManagerFactory();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new JpaTransactionManager(entityManagerFactory());
    }
}
