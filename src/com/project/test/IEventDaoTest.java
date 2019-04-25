package com.project.test;

import com.project.bean.AreaBean;
import com.project.bean.EventBean;
import com.project.dao.IAreaDao;
import com.project.dao.IEventDao;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IEventDaoTest {

    private SqlSession session = null;
    private IEventDao iEventDao = null;
    private IAreaDao iAreaDao = null;

    @org.junit.Before
    public void setUp() throws Exception {
        session = SqlSessionUtil.getSession();
        iEventDao = session.getMapper(IEventDao.class);
        iAreaDao = session.getMapper(IAreaDao.class);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        session.close();
    }

    @Test
    public void addEvent(){
        EventBean eventBean = new EventBean();
        eventBean.setEventName("test231");
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
        Map<String ,String> condition = new HashMap<String, String>();
        condition.put("type","区域名称");
        condition.put("value","卧龙");
        AreaBean areaBean = iAreaDao.findAreaByCondition(condition).get(0);
        eventBean.setHappenPlace(areaBean);
        iEventDao.addEvent(eventBean);
        session.commit();
    }
    @Test
    public void showEventInfo(){
        EventBean eventBean = iEventDao.showEventInfo(1);
        System.out.println(eventBean);
        session.commit();
    }
//    @Test
//    public void showEventInfoByDisasterStage(){
//        List<EventBean> list = iEventDao.showEventInfoByDisasterStage(2);
//        System.out.println(list);
//        session.commit();
//    }
    @Test
    public void updateEventInfo(){
        EventBean eventBean = iEventDao.showEventInfo(1);
        eventBean.setDisasterStage("无法解决，申请专家会审");
        eventBean.setPreventPlan("喷洒农药，加捕鼠笼");
        iEventDao.updateEventInfo(eventBean);
        session.commit();
    }
    @Test
    public void updateDisasterStage(){
        EventBean eventBean = iEventDao.showEventInfo(2);
        eventBean.setDisasterStage("防治中");
        iEventDao.updateEventInfo(eventBean);
        session.commit();
    }
    @Test
    public void findEventByCondition (){
        Map<String,String> condition = new HashMap<String,String>();
        condition.put("type","事件名称");
        condition.put("value","卧龙");
        List<EventBean> list = iEventDao.findEventByCondition(condition);
        System.out.println(list);
        session.commit();
    }
}
