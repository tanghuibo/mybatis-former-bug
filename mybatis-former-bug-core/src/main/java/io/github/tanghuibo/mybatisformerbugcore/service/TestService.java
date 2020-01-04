package io.github.tanghuibo.mybatisformerbugcore.service;

import io.github.tanghuibo.mybatisformerbugcore.bean.TestParam;
import io.github.tanghuibo.mybatisformerbugcore.config.MybatisConfig;
import io.github.tanghuibo.mybatisformerbugcore.dao.TestMapper;
import io.github.tanghuibo.mybatisformerbugcore.tools.MybatisUtils;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Arrays;
/**
 * @author tanghuibo
 * @date 2020/1/3上午12:25
 */
public class TestService {

    SqlSessionFactory getSqlSessionFactory() throws IOException {
        MybatisConfig mybatisConfig = new MybatisConfig();

        DataSource dataSource = mybatisConfig.buildDataSource();
        Environment environment = mybatisConfig.buildEnvironment(dataSource);
        Configuration configuration = mybatisConfig.buildConfiguration(environment);
        mybatisConfig.getXMLMapperBuilder("mapping/TestMapper.xml", configuration);
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = mybatisConfig.getSqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(configuration);
        MybatisUtils.runScript(sqlSessionFactory, "db/schema.sql");
        return sqlSessionFactory;
    }

    public void test() throws IOException {
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        TestParam testParam = new TestParam();
        testParam.setTestIdList(Arrays.asList(1001L, 2002L, 3003L));
       testMapper.batchSelectTest1(testParam);
    }
}
