package com.example;

import oracle.jdbc.pool.OracleDataSource;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * Created by kapil_shrivastava on 11/30/15.
 */
public class KapilOracleTest {
    @Bean
    DataSource dataSource() throws SQLException {

        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser("cmsrep");
        dataSource.setPassword("CMSREPEQST");
        dataSource.setURL("jdbc:oracle:thin:@//10.221.0.169:1521/SPRKEQST");
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }
}
