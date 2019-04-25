package com.project.test;

import com.github.pagehelper.PageInfo;
import com.project.bean.AreaBean;
import com.project.bean.ClassBean;
import com.project.service.IAreaService;
import com.project.service.IClassService;
import com.project.service.impl.AreaServiceImpl;
import com.project.service.impl.ClassServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class IClassServiceTest {


    @org.junit.Before
    public void setUp() throws Exception {
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void addClassTest(){
        IAreaService iAreaService = new AreaServiceImpl();
        IClassService iClassService = new ClassServiceImpl();
        Map<String,String> condition = new HashMap<String,String>();
        condition.put("type","区域名称");
        condition.put("value","卧龙1号地区");
        condition.put("currentPage","1");
        condition.put("pageSize","5");
        PageInfo<AreaBean> page = iAreaService.findByCondition(condition);
        AreaBean areaBean =page.getList().get(0);
        ClassBean classBean = new ClassBean("test523",10,"KKKK","1234564",areaBean);
        iClassService.addClass(classBean);
    }
    @Test
    public void showClassInfoTest(){
        IClassService iClassService = new ClassServiceImpl();
        ClassBean classBean = iClassService.showClassInfoById(1);
        System.out.println(classBean);
    }
    @Test
    public void updateClassInfoTest(){
        IClassService iClassService = new ClassServiceImpl();
        ClassBean classBean = iClassService.showClassInfoById(1);
        classBean.setPrincipalTel("15421478562");
        classBean.setPrincipal("白客");
        iClassService.updateClassInfo(classBean);
    }
    @Test
    public void findClassByConditionTest (){
        IClassService iClassService = new ClassServiceImpl();
        Map<String,String> condition = new HashMap<String,String>();
        condition.put("currentPage","1");
        condition.put("pageSize","3");
        condition.put("type","小班名称");
        condition.put("value","卧龙");
        PageInfo<ClassBean> page = iClassService.findClassByCondition(condition);
    }
}
