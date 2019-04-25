package com.project.test;

import com.project.bean.PotionManagementBean;
import com.project.dao.IPotionManagementDao;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IPotionManagementDaoTest {
    SqlSession session=null;
    IPotionManagementDao iPotionManagementDao=null;
    @Before
    public void load(){
        session= SqlSessionUtil.getSession();
        iPotionManagementDao= session.getMapper(IPotionManagementDao.class);
    }
    @After
    public void tearDown() throws Exception {
        session.close();
    }
    @Test
    public void addPotionTest(){
        PotionManagementBean potionManagementBean=new PotionManagementBean();
        potionManagementBean.setPotionName("测试");
        potionManagementBean.setPreventCureTypeId(1);
        potionManagementBean.setDiseasesAndPestsName("测试1");
        potionManagementBean.setTreeSpecies("测试树1");
        iPotionManagementDao.addPotion(potionManagementBean);
        session.commit();
    }
    @Test
    public void showPotionInfoTest(){
        PotionManagementBean potionManagementBean=new PotionManagementBean();
        Map<String,String> condition = new HashMap<String,String>();
        condition.put("name","消毒");
        condition.put("type","2");
        condition.put("suitable","1");
        List<PotionManagementBean> list = iPotionManagementDao.showPotionInfo(condition);
        System.out.println(list);
        session.commit();
    }
}
