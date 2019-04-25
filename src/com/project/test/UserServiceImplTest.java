package com.project.test;

import com.github.pagehelper.PageInfo;
import com.project.bean.UserBean;
import com.project.service.IUserService;
import com.project.service.impl.UserServiceImpl;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImplTest {
    SqlSession session=null;
    IUserService userService=new UserServiceImpl();
    @Before
    public void setUp() throws Exception {
        session= SqlSessionUtil.getSession();
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

//    @Test
    public void login() {
        try {
       UserBean user= userService.login("admain","123");
            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    @Test
    public void findByCondition() {
        Map<String,String>condition=new HashMap();
        condition.put("currentPage","1");
        condition.put("pageSize","10");
        try {
         PageInfo<UserBean> page= userService.findByCondition(condition);
            System.out.println(page);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    @Test
    public void findAllUser() {
        try {
         List<UserBean> user= userService.findAllUser();
            System.out.println(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addUser() {

    }

    @Test
    public void deleteUser() {

    }

    @Test
    public void updateUser() {
        UserBean user=new UserBean();
        user.setId(Integer.parseInt("20"));
        user.setPwd("123");
        user.setUserScale("专家管理员");
        try {
            userService.updateUser(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findUserByuserScale() {

    }
}