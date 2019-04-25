package com.project.test;

import com.project.bean.SpecialistBean;
import com.project.dao.ISpecialistDao;
import com.project.service.IExpertEventService;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SpecialistServiceImplTest {
    private SqlSession session=null;
    private ISpecialistDao iSpecialistDao=null;

    @Before
    public void setUp() throws Exception {
        session= SqlSessionUtil.getSession();
        iSpecialistDao=session.getMapper(ISpecialistDao.class);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    public void findSpecialistByCondition() throws Exception {
        Map<String,String>map=new HashMap<>();
        map.put("specialistName","专家2");
        map.put("workunit",null);
        map.put("speciality",null);
        List<SpecialistBean>list=iSpecialistDao.searchSpecialist(map);
        System.out.println(list);
    }

    @Test
    public void addSpecialistInformation() throws Exception {
        SpecialistBean specialistBean=new SpecialistBean();
        specialistBean.setSpecialistName("22");
        specialistBean.setWorkunit("222");
        specialistBean.setSpeciality("33");
        specialistBean.setDuty("333");
        specialistBean.setTelphone("44444444");
        specialistBean.setBirthday("1996-01-15");
        specialistBean.setSex("男");
        specialistBean.setAddress("888");
        specialistBean.setEmail("222223");
        specialistBean.setPicture("3.jpg");
        iSpecialistDao.addSpecialistInformation(specialistBean);
      session.commit();
    }

    @Test
    public void getSpecialistInformationById() throws Exception {
        SpecialistBean specialistBean=iSpecialistDao.getSpecialistInformationById(2);
        System.out.println(specialistBean);
    }



    @Test
    public void updateSpecialistInformation() throws Exception {
        SpecialistBean specialistBean=iSpecialistDao.getSpecialistInformationById(3);
        specialistBean.setTelphone("1234567890");
        specialistBean.setDuty("22");
        specialistBean.setWorkunit("11");
        specialistBean.setEmail("252");
        iSpecialistDao.updateSpecialistInformation(specialistBean);
        session.commit();
    }

    @Test
    public void deleteSpecialistInformation() throws Exception {
       iSpecialistDao.deleteSpecialistInformation(2);
       session.commit();

    }
}