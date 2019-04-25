package com.project.test;

import com.github.pagehelper.PageInfo;
import com.project.bean.MechanicalManagementBean;
import com.project.service.IMechanicalManagementService;
import com.project.service.impl.MechanicalManagementServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MechanicalManagementServiceImplTest {
    IMechanicalManagementService iMechanicalManagementService = new MechanicalManagementServiceImpl();
    @Test
    public void showMechanicalInfoTest(){
        Map<String,String> condition = new HashMap<String, String>();
        condition.put("currentPage","1");
        condition.put("pageSize","6");
        condition.put("name","捕");
        condition.put("type","2");
        PageInfo<MechanicalManagementBean> page = iMechanicalManagementService.showMechanicalInfo(condition);
        System.out.println(page.getList());
    }
    @Test
    public void addMechanicalTest(){
        MechanicalManagementBean mechanicalManagementBean=new MechanicalManagementBean();
        mechanicalManagementBean.setMechanicalName("测试2");
        mechanicalManagementBean.setPreventCureTypeId(3);
        mechanicalManagementBean.setMainUse("测试2");
        iMechanicalManagementService.addMechanical(mechanicalManagementBean);
    }
}
