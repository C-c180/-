package com.project.test;

import com.project.bean.AreaBean;
import com.project.dao.IAreaDao;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IAreaDaoTest {

    private SqlSession session = null;
    private IAreaDao iAreaDao = null;

    @org.junit.Before
    public void setUp() throws Exception {
       session = SqlSessionUtil.getSession();
       iAreaDao = session.getMapper(IAreaDao.class);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        session.close();
    }
    @Test
    public void addArea(){
        AreaBean areaBean = new AreaBean("test1","test","test","test");
        iAreaDao.addArea(areaBean);
        session.commit();
    }
    @Test
    public void findAreaByCondition(){
        Map<String,String> condition = new HashMap<String,String>();
        condition.put("type","区域名称");
        condition.put("value","卧龙");
        List<AreaBean>list = iAreaDao.findAreaByCondition(condition);
        System.out.println(list);
        session.commit();
    }
    @Test
    public void findAreaById(){
        AreaBean areaBean = iAreaDao.findAreaById(1);
        System.out.println(areaBean);
    }

}