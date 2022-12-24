package com.threat.sim;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
@Configuration
public class JDBCBuilder {
    private static String driver = "org.postgresql.Driver";
    private static String url = "jdbc:postgresql://localhost:5432/";
    private static String dbname = "inz";
    private static String username = "postgres";
    private static String password = "2943754";
    @Bean(name = "JdbcBuilder")
    public DataSource mysqlDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url + dbname);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }
}
