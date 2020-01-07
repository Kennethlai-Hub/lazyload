package com.ibranco.mybatis.lazyload.test;

import com.ibranco.mybatis.lazyload.domain.Account;
import com.ibranco.mybatis.lazyload.domain.User;
import com.ibranco.mybatis.lazyload.mapper.AccountMapper;
import com.ibranco.mybatis.lazyload.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserTest {
    private Logger logger = Logger.getLogger(UserTest.class);
    private InputStream inputStream;
    private SqlSession sqlSession;
    private UserMapper userDao;
    private AccountMapper accountMapper;

    @Before
    public void init() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        userDao = sqlSession.getMapper(UserMapper.class);
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }
    @After
    public void destory() throws IOException {
        sqlSession.close();
        inputStream.close();

    }
    @Test
    public void testFindAll() {
        List<User> userList = userDao.findAll();
        for (User user :userList){
            System.out.println(user);
            logger.info(user);
        }
    }
    @Test
    public void testFindAllAccount(){
        List<Account> list = accountMapper.findAll();
        for (Account item :list){
            logger.info(item);
        }
    }

}
