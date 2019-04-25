package com.project.test;

import com.github.pagehelper.PageInfo;
import com.project.bean.LogBean;
import com.project.service.ILogService;
import com.project.service.impl.LogServiceImpl;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogServiceImplTest {
    private ILogService logService=new LogServiceImpl();
    private SqlSession session=null;
    @Before
    public void setUp() throws Exception {
        session= SqlSessionUtil.getSession();
        logService = new LogServiceImpl();
    }

    @After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    public void findAllLog() {
      List<LogBean> list= logService.findAllLog();
        System.out.println(list);
        session.commit();

    }

    @Test
    public void findByCondition() {
        Map<String,String> condition=new HashMap();
        condition.put("currentPage","1");
        condition.put("pageSize","10");
     PageInfo<LogBean> page= logService.findByCondition(condition);
        System.out.println(page);
        session.commit();

    }

    @Test
    public void findLogByStartDateAndEndDate() {
        List <LogBean> list=logService.findLogByStartDateAndEndDate("2012-05-06","2019-01-01");
        System.out.println(list);
        session.commit();
    }

}