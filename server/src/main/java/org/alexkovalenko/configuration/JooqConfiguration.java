package org.alexkovalenko.configuration;

import org.jooq.SQLDialect;
import org.jooq.conf.MappedSchema;
import org.jooq.conf.RenderMapping;
import org.jooq.conf.Settings;
import org.jooq.impl.DataSourceConnectionProvider;
import org.jooq.impl.DefaultConfiguration;
import org.jooq.impl.DefaultDSLContext;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableTransactionManagement
public class JooqConfiguration {
    @Autowired
    private DataSource dataSource;

    @Bean
    public DataSourceConnectionProvider connectionProvider() {
        return new DataSourceConnectionProvider(new TransactionAwareDataSourceProxy(dataSource));
    }

    @Bean
    public DefaultDSLContext dslContext() throws SQLException {
        return new DefaultDSLContext(configuration());
    }

    @Bean
    public DefaultConfiguration configuration() throws SQLException {
        DefaultConfiguration configuration = new DefaultConfiguration();
        configuration.set(connectionProvider());
        configuration.set(SQLDialect.MYSQL);
        Settings settings = new Settings();
        settings.withRenderMapping(
                new RenderMapping().withSchemata(
                        new MappedSchema().withInput("expenses_logger")
                                .withOutput(dataSource.getConnection().getCatalog())));
        configuration.set(settings);
        return configuration;
    }

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
