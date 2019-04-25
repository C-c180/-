package com.project.test;

import com.project.bean.DiseaseBean;
import com.project.dao.IDiseaseDao;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IDiseaseDaoTest {
    SqlSession session=null;
    IDiseaseDao iDiseaseDao=null;
    @Before
    public void setUp() throws Exception {
        session = SqlSessionUtil.getSession();
        iDiseaseDao = session.getMapper(IDiseaseDao.class);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }
    //@Test
    public void findDiseaseByConditionTest(){
        Map<String,String> map = new HashMap<>();
        map.put("diseaseName", null);
        map.put("symptom", "'症状99'");
        List<DiseaseBean> list = iDiseaseDao.findDiseaseByCondition(map);
        System.out.println(list);
    }
   // @Test
    public void addDisease(){
        DiseaseBean diseaseBean=new DiseaseBean();
        diseaseBean.setName("111");
        diseaseBean.setPathogeny("222");
        diseaseBean.setSymptom("333");
        diseaseBean.setRule("444");
        diseaseBean.setMainDanger("555");
        diseaseBean.setMeasure("666");
        diseaseBean.setPicture("666");
        iDiseaseDao.addDisease(diseaseBean);
        session.commit();
    }
    @Test
    public void findDiseaseById(){
        DiseaseBean diseaseBean = iDiseaseDao.findDiseaseId(1);
        System.out.println(diseaseBean);
    }
}