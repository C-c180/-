package com.project.test;

import com.project.bean.MechanicalManagementBean;
import com.project.dao.IMechanicalManagementDao;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IMechanicalManagementDaoTest {
    private SqlSession session = null;
    IMechanicalManagementDao iMechanicalManagementDao=null;
    @Before
    public void load(){
        session= SqlSessionUtil.getSession();
        iMechanicalManagementDao= session.getMapper(IMechanicalManagementDao.class);
    }
    @After
    public void tearDown() throws Exception {
        session.close();
    }
    @Test
    public void addMechanicalTest(){
        MechanicalManagementBean mechanicalManagementBean=new MechanicalManagementBean();
        mechanicalManagementBean.setMechanicalName("测试1");
        mechanicalManagementBean.setPreventCureTypeId(1);
        mechanicalManagementBean.setMainUse("测试1");
        iMechanicalManagementDao.addMechanical(mechanicalManagementBean);
        session.commit();
    }
    @Test
    public void showMechanicalInfoTest(){
        Map<String,String> condition = new HashMap<String,String>();
        condition.put("name","捕");
        condition.put("type","2");
        List<MechanicalManagementBean> list = iMechanicalManagementDao.showMechanicalInfo(condition);
        System.out.println(list);
        session.commit();
    }
}
