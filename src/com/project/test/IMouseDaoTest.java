package com.project.test;

import com.project.bean.MouseBean;
import com.project.dao.IMouseDao;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IMouseDaoTest {
    SqlSession session=null;
    IMouseDao iMouseDao=null;
    @Before
    public void setUp() throws Exception {
        session = SqlSessionUtil.getSession();
        iMouseDao = session.getMapper(IMouseDao.class);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }
    //@Test
    public void findMouseByConditionTest(){
        Map<String,String> map = new HashMap<>();
        map.put("name", null);
        List<MouseBean> list = iMouseDao.findMouseByCondition(map);
        System.out.println(list);
    }
    //@Test
    public void addMouseTest(){
        MouseBean mouseBean=new MouseBean();
        mouseBean.setName("111");
        mouseBean.setFood("222");
        mouseBean.setBreed("333");
        mouseBean.setEnemy("444");
        mouseBean.setMeasure("555");
        mouseBean.setMainDanger("666");
        mouseBean.setPicture("666");
        iMouseDao.addMouse(mouseBean);
        session.commit();
    }
    //@Test
    public void findMouseById(){
        MouseBean mouseBean = iMouseDao.findMouseById(1);
        System.out.println(mouseBean);
    }
}