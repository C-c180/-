package com.project.test;

import com.project.bean.UserBean;
import com.project.dao.IUserDao;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {
    IUserDao iUserDao=null;
    SqlSession session=null;
    @Before
    public void setUp() throws Exception {
       session= SqlSessionUtil.getSession();
       iUserDao=session.getMapper(IUserDao.class);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }
//    @Test
    public void login() {
        try {
        UserBean bean= iUserDao.login("admain","123");
        session.commit();
            System.out.println(bean);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    @Test
    public void findByCondition() {
        Map<String,String> condition=new HashMap();
        condition.put("currentPage","1");
        condition.put("pageSize","10");
        try {
            List<UserBean> page = iUserDao.findUserCondition(condition);
            session.commit();
            System.out.println(page);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    @Test
    public void findAllUser() {
        try {
        List<UserBean> list= iUserDao.findAllUser();
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    @Test
    public void addUser() {
        UserBean userBean=new UserBean();
        userBean.setUserName("测试数据");
        userBean.setPwd("11111");
        userBean.setRealName("测试");
        userBean.setUserScale("超级管理员");
        try {
            iUserDao.addUser(userBean);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteUser() {
        try {
            iUserDao.deleteUser(Integer.parseInt("22"));
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

//    @Test
    public void updateUser() {
        UserBean userBean=new UserBean();
        userBean.setId(Integer.parseInt("22"));
        userBean.setPwd("6666");
        userBean.setUserScale("库房管理员");
        try {
            iUserDao.updateUser(userBean);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }
//    @Test
    public void findUserByuserScale() {
        try {
        List<UserBean> list=iUserDao.findUserByuserScale(Integer.parseInt("2"));
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}