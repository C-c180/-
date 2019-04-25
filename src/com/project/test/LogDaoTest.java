package com.project.test;

import com.project.bean.LogBean;
import com.project.dao.ILogDao;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class LogDaoTest {
private ILogDao iLogDao=null;
private SqlSession session=null;
    @Before
    public void setUp() throws Exception {
        session= SqlSessionUtil.getSession();
     iLogDao=session.getMapper(ILogDao.class);
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    public void findAllLog() {
     List<LogBean> list= iLogDao.findAllLog();
        System.out.println(list);
        session.commit();
    }
    @Test
    public void findByCondition() {
        Map<String,String> condition=new HashMap();
        condition.put("currentPage","1");
        condition.put("pageSize","10");
       List<LogBean> log= iLogDao.findByCondiction(condition);
        System.out.println(log);
    }
    @Test
    public void findLogByStartDateAndEndDate() {
    }
}