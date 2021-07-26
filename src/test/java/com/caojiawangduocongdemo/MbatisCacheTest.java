package com.caojiawangduocongdemo;

import com.caojiawangduocongdemo.dao.UserMapper;
import com.caojiawangduocongdemo.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MbatisCacheTest {
    private static final Logger logger = LoggerFactory.getLogger(MbatisCacheTest.class);
    private SqlSession sqlSession;

    @Autowired
    private UserMapper userMapper;

    @Before
    public void init() throws IOException {
        String mybatisConfig = "mybatis-generator/generatorConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(mybatisConfig);
        sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession();
    }

    @Test
    public void test(){
        User user = userMapper.selectByPrimaryKey("2342243241");
        logger.info("第一次查询结果",user);

        User user2 = userMapper.selectByPrimaryKey("2342243241");
        logger.info("第一次查询结果",user2);

    }

    @After
    public void close(){
        sqlSession.close();
    }
}
