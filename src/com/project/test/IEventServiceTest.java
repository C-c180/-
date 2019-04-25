package com.project.test;

import com.github.pagehelper.PageInfo;
import com.project.bean.AreaBean;
import com.project.bean.EventBean;
import com.project.service.IAreaService;
import com.project.service.IEventService;
import com.project.service.impl.AreaServiceImpl;
import com.project.service.impl.EventServiceImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class IEventServiceTest {

    IEventService iEventService = new EventServiceImpl();

    @Test
    public void findEventByConditionTest(){
        Map<String,String> condition = new HashMap<String,String>();
        condition.put("currentPage","1");
        condition.put("pageSize","3");
        condition.put("type","事件名称");
        condition.put("value","卧龙");
        PageInfo<EventBean> page = iEventService.findEventByCondition(condition);
        System.out.println(page);
    }

    @Test
    public void showEventInfoTest(){
        EventBean eventBean = iEventService.showEventInfo(1);
        System.out.println(eventBean);
    }
    @Test
    public void applyCheckTest(){
        EventBean eventBean = iEventService.showEventInfo(3);
        eventBean.setDisasterStage("无法解决，申请专家会商");
        iEventService.applyCheck(eventBean);
    }

    @Test
    public void updateEventInfoTest(){
        EventBean eventBean = iEventService.showEventInfo(4);
        eventBean.setDisasterStage("无法处理，申请专家会商");
        eventBean.setPreventPlan("与当地林业局配合处理");
        iEventService.updateEventInfo(eventBean);
    }
    @Test
    public void addEventTest(){
        IAreaService iAreaService = new AreaServiceImpl();
        EventBean eventBean = new EventBean();
        eventBean.setEventName("test777777");
        eventBean.setDateTimes("test444");
        eventBean.setDisasterStage("已经得到控制");
        eventBean.setDisasterDesc("test");
        eventBean.setLoss(20);
        eventBean.setPreventPlan("test");
        eventBean.setImagePath("test");
        eventBean.setDisastersType("test");
        eventBean.setFoundWay("test");
        eventBean.setAdvice("testhhh");
        eventBean.setAreaOfInfluence(30);
        AreaBean areaBean = iAreaService.findAreaById(5);
        eventBean.setHappenPlace(areaBean);
        iEventService.addEvent(eventBean);
    }
}
