package com.project.test;

import com.project.bean.CountOutboundBean;
import com.project.bean.OutboundManagementBean;
import com.project.dao.IOutboundManagementDao;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IOutboundManagementDaoTest {
    SqlSession session=null;
    IOutboundManagementDao iOutboundManagementDao=null;
    @Before
    public void load(){
        session= SqlSessionUtil.getSession();
        iOutboundManagementDao= session.getMapper(IOutboundManagementDao.class);
    }
    @After
    public void tearDown() throws Exception {
        session.close();
    }
    @Test
    public void addOutboundInformationTest(){
        OutboundManagementBean outboundManagementBean=new OutboundManagementBean();
        outboundManagementBean.setOutboundTypeId(2);
        outboundManagementBean.setPreventCureTypeId(2);
        outboundManagementBean.setItemName("测试1");
        outboundManagementBean.setRecipientsNum(100);
        outboundManagementBean.setClassId(4);
        outboundManagementBean.setMainUse("不晓得啥子用1");
        iOutboundManagementDao.addOutboundInformation(outboundManagementBean);
        session.commit();
    }
    @Test
    public void getOutboundInformationByConditionTest(){
        OutboundManagementBean outboundManagementBean = new OutboundManagementBean();
        Map<String,String> condition = new HashMap<String,String>();
        condition.put("startDate","2018-11-20");
        condition.put("endDate","2018-11-24");
        List<OutboundManagementBean> list = iOutboundManagementDao.showOutboundInfo(condition);
        System.out.println(list);
        session.commit();
    }
    @Test
    public void obtainReportShowData(){
        List<CountOutboundBean> i=iOutboundManagementDao.obtainReportShowData();
        System.out.println(i);
        session.commit();
    }
}
