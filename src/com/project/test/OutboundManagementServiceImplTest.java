package com.project.test;

import com.github.pagehelper.PageInfo;
import com.project.bean.OutboundManagementBean;
import com.project.service.IOutboundManagementService;
import com.project.service.impl.OutboundManagementServiceImpl;
import org.junit.Test;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class OutboundManagementServiceImplTest {
    IOutboundManagementService iPotionManagementService=new OutboundManagementServiceImpl();
    @Test
    public void showOutboundInfoTest(){
        Map<String,String> condition = new HashMap<String, String>();
        condition.put("currentPage","1");
        condition.put("pageSize","6");
        condition.put("startDate","2018-11-20");
        condition.put("endDate","2018-11-24");
        PageInfo<OutboundManagementBean> page = iPotionManagementService.showOutboundInfo(condition);
        System.out.println(page.getList());
    }
    @Test
    public void addOutboundInformationTest(){
        OutboundManagementBean outboundManagementBean=new OutboundManagementBean();
        outboundManagementBean.setOutboundTypeId(1);
        outboundManagementBean.setPreventCureTypeId(3);
        outboundManagementBean.setItemName("测试5");
        outboundManagementBean.setRecipientsNum(200);
        outboundManagementBean.setClassId(5);
        outboundManagementBean.setMainUse("不晓得啥子用5");
        iPotionManagementService.addOutboundInformation(outboundManagementBean);
    }
}
