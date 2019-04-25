package com.project.test;

import com.github.pagehelper.PageInfo;
import com.project.bean.MouseBean;
import com.project.service.IMouseService;
import com.project.service.impl.MouseServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MouseServiceImplTest {
    IMouseService service=null;
    @Before
    public void setUp() throws Exception {
        service=new MouseServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findMouseByCondition() {
        Map<String,String> map = new HashMap<>();
        map.put("pageNum", "1");
        map.put("pageSize", "100");
        map.put("name", null);
        PageInfo<MouseBean> pageInfo = service.findMouseByCondition(map);
        System.out.println(pageInfo);
    }

    @Test
    public void addMouse() {
        MouseBean mouseBean=new MouseBean();
        mouseBean.setName("111");
        mouseBean.setFood("222");
        mouseBean.setBreed("333");
        mouseBean.setEnemy("444");
        mouseBean.setMeasure("555");
        mouseBean.setMainDanger("666");
        mouseBean.setPicture("666");
        service.addMouse(mouseBean);
    }

    @Test
    public void findById() {
        MouseBean mouseBean = service.findById(1);
    }
}