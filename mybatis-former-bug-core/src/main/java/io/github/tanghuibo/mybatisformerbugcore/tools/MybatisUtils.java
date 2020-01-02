package io.github.tanghuibo.mybatisformerbugcore.tools;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author tanghuibo
 * @date 2020/1/3上午12:41
 */
public class MybatisUtils {

    public static void runScript(SqlSessionFactory sqlSessionFactory, String resource) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Connection connection = sqlSession.getConnection();
        try {
            ScriptRunner runner = new ScriptRunner(connection);
            runner.setAutoCommit(false);
            runner.setStopOnError(false);
            runner.setLogWriter(new PrintWriter(System.out));
            Reader reader = Resources.getResourceAsReader(resource);
            runner.runScript(reader);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            sqlSession.close();
        }
    }
}
