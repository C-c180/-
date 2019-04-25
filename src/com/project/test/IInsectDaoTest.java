package com.project.test;

import com.project.bean.InsectBean;
import com.project.dao.IInsectDao;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IInsectDaoTest {
    SqlSession session=null;
    IInsectDao iInsectDao=null;
    @Before
    public void setUp() throws Exception {
        session = SqlSessionUtil.getSession();
        iInsectDao=session.getMapper(IInsectDao.class);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }
    //@Test
    public void findInsectByCondition(){
        Map<String,String> map = new HashMap<>();
        map.put("insectName", null);
        map.put("hostName", "'寄主100'");
        List<InsectBean> list = iInsectDao.findInsectByCondition(map);
        System.out.println(list);
    }
    //@Test
    public void addInsectTest(){
        InsectBean insectBean=new InsectBean();
        insectBean.setName("111");
        insectBean.setHostName("222");
        insectBean.setBreed("333");
        insectBean.setEnemy("444");
        insectBean.setControlling("555");
        insectBean.setDanger("666");
        insectBean.setChildPicture("777");
        insectBean.setInsectPicture("888");
        iInsectDao.addInsect(insectBean);
        session.commit();
    }
    @Test
    public void findInsectById(){
        InsectBean insectBean = iInsectDao.findInsectById(50000);
    }
}