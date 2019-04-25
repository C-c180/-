package com.project.test;

import com.project.bean.AreaBean;
import com.project.bean.ClassBean;
import com.project.dao.IAreaDao;
import com.project.dao.IClassDao;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IClassDaoTest {

    private SqlSession session = null;
    private IClassDao iClassDao = null;
    private IAreaDao iAreaDao = null;

    @org.junit.Before
    public void setUp() throws Exception {
        session = SqlSessionUtil.getSession();
        iClassDao = session.getMapper(IClassDao.class);
        iAreaDao = session.getMapper(IAreaDao.class);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    public void addClass(){
        Map<String,String> condition = new HashMap<String,String>();
        condition.put("type","区域名称");
        condition.put("value","卧龙1号地区");
        List<AreaBean> list =iAreaDao.findAreaByCondition(condition);
        AreaBean areaBean = list.get(0);
        ClassBean classBean = new ClassBean("test3131",10,"wang","1234564",areaBean);
        iClassDao.addClass(classBean);
        session.commit();
    }
    @Test
    public void showClassInfo(){
        ClassBean classBean = iClassDao.showClassInfo(1);
        System.out.println(classBean);
    }
    @Test
    public void updateClassInfo(){
        ClassBean classBean = iClassDao.showClassInfo(1);
        classBean.setPrincipalTel("15421478562");
        classBean.setPrincipal("王大锤");
        iClassDao.updateClassInfo(classBean);
        session.commit();
    }
    @Test
    public void findClassByCondition (){
        Map<String,String> condition = new HashMap<String,String>();
        condition.put("type","小班名称");
        condition.put("value","卧龙");
        List<ClassBean>list = iClassDao.findClassByCondition(condition);
        System.out.println(list);
        session.commit();
    }
}
