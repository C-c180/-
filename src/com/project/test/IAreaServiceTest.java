package com.project.test;

import com.github.pagehelper.PageInfo;
import com.project.bean.AreaBean;
import com.project.service.IAreaService;
import com.project.service.impl.AreaServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class IAreaServiceTest {

    IAreaService iAreaService = new AreaServiceImpl();

    @Test
    public void findByConditionTest(){
        Map <String,String> condition = new HashMap<String, String>();
        condition.put("currentPage","1");
        condition.put("pageSize","3");
        condition.put("type","区域名称");
        condition.put("value","卧龙");
        PageInfo<AreaBean> page = iAreaService.findByCondition(condition);
        System.out.println(page.getList());
    }

    @Test
    public void addAreaTest(){
        AreaBean areaBean = new AreaBean("test8786575","test","test","test");
        iAreaService.addArea(areaBean);
    }
    @Test
    public void findAreaById(){
        AreaBean areaBean = iAreaService.findAreaById(1);
    }
}
