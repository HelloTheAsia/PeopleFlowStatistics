package com.hiasia.peopleflowstatistics.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceConfig {
  @Autowired Environment env;

  @Value("spring.datasource.driver-class-name")
  private String driverClassName;

  @Value("spring.datasource.url")
  private String url;

  @Bean
  public DataSource dataSource() {
    final DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty(driverClassName));
    dataSource.setUrl(env.getProperty(url));
    return dataSource;
  }
}
