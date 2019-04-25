package com.project.test;

import com.github.pagehelper.PageInfo;
import com.project.bean.PotionManagementBean;
import com.project.service.IPotionManagementService;
import com.project.service.impl.PotionManagementServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PotionManagementServiceImplTest {
    IPotionManagementService iPotionManagementService=new PotionManagementServiceImpl();
    @Test
    public void showPotionInfoTest(){
        Map<String,String> condition = new HashMap<String, String>();
        condition.put("currentPage","1");
        condition.put("pageSize","6");
        condition.put("name","消毒");
        condition.put("type","2");
        condition.put("suitable","1");
        PageInfo<PotionManagementBean> page = iPotionManagementService.showPotionInfo(condition);
        System.out.println(page.getList());
    }
    @Test
    public void addPotionTest(){
        PotionManagementBean potionManagementBean=new PotionManagementBean();
        potionManagementBean.setPotionName("测3");
        potionManagementBean.setPreventCureTypeId(2);
        potionManagementBean.setDiseasesAndPestsName("测试2");
        potionManagementBean.setTreeSpecies("测试树23");
        iPotionManagementService.addPotion(potionManagementBean);
    }
}
