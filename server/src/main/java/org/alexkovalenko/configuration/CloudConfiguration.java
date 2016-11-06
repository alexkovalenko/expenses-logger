package org.alexkovalenko.configuration;

import com.google.common.collect.ImmutableMap;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.cloud.service.PooledServiceConnectorConfig;
import org.springframework.cloud.service.relational.DataSourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
@Profile("cloud")
public class CloudConfiguration {
    @Bean
    public Cloud cloud() {
        return new CloudFactory().getCloud();
    }

    @Bean
    public DataSource dataSource() {
        ImmutableMap<String, Object> connectionProperties = ImmutableMap.<String, Object>builder()
                .put("connectionProperties", "useUnicode=yes;characterEncoding=utf8;")
                .build();
        DataSourceConfig dataSourceConfig = new DataSourceConfig(new PooledServiceConnectorConfig.PoolConfig(4, 30000), null, connectionProperties);
        return cloud().getSingletonServiceConnector(DataSource.class, dataSourceConfig);
    }
}
