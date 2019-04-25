package com.project.test;

import com.github.pagehelper.PageInfo;
import com.project.bean.InsectBean;
import com.project.service.IInsectService;
import com.project.service.impl.InsectServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class InsectServiceImplTest {
    IInsectService service=null;

    @Before
    public void setUp() throws Exception {
        service=new InsectServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void findInsectByCondition() {
        Map<String,String> map=new HashMap();
        map.put("pageNum", "1");
        map.put("pageSize", "100");
        PageInfo<InsectBean> pageInfo = service.findInsectByCondition(map);
        System.out.println(pageInfo);
    }

    @Test
    public void addInsect() {
        InsectBean insectBean=new InsectBean();
        insectBean.setName("111");
        insectBean.setHostName("222");
        insectBean.setBreed("333");
        insectBean.setEnemy("444");
        insectBean.setControlling("555");
        insectBean.setDanger("666");
        insectBean.setChildPicture("777");
        insectBean.setInsectPicture("888");
        service.addInsect(insectBean);
    }

    @Test
    public void findById() {
        InsectBean insectBean = service.findInsectById(1);
        System.out.println(insectBean);
    }
}