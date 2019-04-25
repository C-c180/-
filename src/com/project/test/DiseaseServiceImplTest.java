package com.project.test;

import com.github.pagehelper.PageInfo;
import com.project.bean.DiseaseBean;
import com.project.service.IDiseaseService;
import com.project.service.impl.DiseaseServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class DiseaseServiceImplTest {
    IDiseaseService service=null;
    @Before
    public void setUp() throws Exception {
        service=new DiseaseServiceImpl();
    }
    @Test
    public void findDiseaseByCondition() {
        Map<String,String> map = new HashMap<>();
        map.put("pageNum", "1");
        map.put("pageSize","10");
        //map.put("diseaseName", null);
        //map.put("symptom", "'症状99'");
        PageInfo<DiseaseBean> pageInfo = service.findDiseaseByCondition(map);
        System.out.println(pageInfo);
    }

    @Test
    public void addDiease() {
        DiseaseBean diseaseBean=new DiseaseBean();
        diseaseBean.setName("111");
        diseaseBean.setPathogeny("222");
        diseaseBean.setSymptom("333");
        diseaseBean.setRule("444");
        diseaseBean.setMainDanger("555");
        diseaseBean.setMeasure("666");
        diseaseBean.setPicture("666");
        service.addDiease(diseaseBean);
    }

    @Test
    public void findById() {
        DiseaseBean diseaseBean = service.findById(1);
    }
}