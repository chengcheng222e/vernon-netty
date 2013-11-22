package com.vernon.netty.core.common.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created with IntelliJ IDEA.
 * User: chenyuan
 * Date: 13-11-21
 * Time: PM4:27
 * To change this template use File | Settings | File Templates.
 */
public class DaoFactory {

    private static final Logger logger = LoggerFactory.getLogger(DaoFactory.class);
    private static SqlSessionFactory sqlSessionFactory;


    static {
        String source = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(source) ;
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            logger.error("---------- mybatis build failed ----------");
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
