package com.project.test;

import com.project.bean.ExpertEventBean;
import com.project.dao.IAreaDao;
import com.project.dao.IEventDao;
import com.project.dao.IExpertEventDao;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ExpertEventServiceImplTest {
    private SqlSession session = null;
    private IExpertEventDao iExpertEventDao = null;
    private IEventDao iEventDao = null;
    private IAreaDao iAreaDao = null;

    @Before
    public void setUp() throws Exception {
        session = SqlSessionUtil.getSession();
        iExpertEventDao = session.getMapper(IExpertEventDao.class);
        iEventDao = session.getMapper(IEventDao.class);
        iAreaDao = session.getMapper(IAreaDao.class);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    public void searchExpertInfo() throws Exception {

        List<ExpertEventBean> expertEventBean = iExpertEventDao.searchExpertInfo(2);
        System.out.println(expertEventBean);


    }

    @Test
    public void addExpertInformation() throws Exception {
        ExpertEventBean expertEventBean=new ExpertEventBean();
        expertEventBean.setEventId(5);
        expertEventBean.setResult("111");
        expertEventBean.setDataTime("2019-4-16");
        expertEventBean.setStaff("测试");
       iExpertEventDao.addExpertInformation(expertEventBean);
       session.commit();
    }

}