package io.github.tanghuibo.mybatisformerbugcore.config;

import io.github.tanghuibo.mybatisformerbugcore.dao.TestMapper;
import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author tanghuibo
 * @date 2020/1/3上午12:09
 */
public class MybatisConfig {

    public DataSource buildDataSource() {
        String driver = "org.hsqldb.jdbcDriver";
        String url = "jdbc:hsqldb:file:test.db";
        String username = "sa";
        String password = "";
        return new UnpooledDataSource(driver, url, username, password);
    }

    public Environment buildEnvironment(DataSource dataSource) {
        return new Environment("test", new JdbcTransactionFactory(), dataSource);
    }

    public Configuration buildConfiguration(Environment environment) {
        Configuration configuration = new Configuration(environment);
        configuration.addMapper(TestMapper.class);
        configuration.setLogImpl(StdOutImpl.class);
        return configuration;
    }

    public XMLMapperBuilder getXMLMapperBuilder(String resource, Configuration configuration) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream(resource);
        XMLMapperBuilder xmlStatementBuilder = new XMLMapperBuilder(inputStream, configuration, resource,
                configuration.getSqlFragments());
        xmlStatementBuilder.parse();
        return xmlStatementBuilder;
    }


    public SqlSessionFactoryBuilder getSqlSessionFactoryBuilder() {
        return new SqlSessionFactoryBuilder();
    }
}
