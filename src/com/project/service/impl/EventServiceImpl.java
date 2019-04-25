package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.EventBean;
import com.project.bean.ExpertEventBean;
import com.project.dao.IEventDao;
import com.project.dao.IExpertEventDao;
import com.project.service.IEventService;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class EventServiceImpl implements IEventService {

    SqlSession session = SqlSessionUtil.getSession();
    IEventDao iEventDao = session.getMapper(IEventDao.class);
    IExpertEventDao iExpertEventDao = session.getMapper(IExpertEventDao.class);
    @Override
    public PageInfo<EventBean> findEventByCondition(Map<String, String> condition) {
        int currentPage = Integer.parseInt(condition.get("currentPage"));
        int pageSize = Integer.parseInt(condition.get("pageSize"));
        PageHelper.startPage(currentPage,pageSize);
        List <EventBean> list = iEventDao.findEventByCondition(condition);
        PageInfo<EventBean> page= new PageInfo<EventBean>(list);
        session.close();
        return page;
    }

    @Override
    public EventBean showEventInfo(int eventId) {
        EventBean eventBean = iEventDao.showEventInfo(eventId);
        System.out.println(eventBean.getDisasterStage());
        String advice="";
        try {
            List<ExpertEventBean>list=iExpertEventDao.searchExpertInfo(eventId);
            ExpertEventBean expertEventBean = null;
            eventBean.setList(list);
            if(list.size()!=0){
                 expertEventBean = list.get((list.size()-1));
                if(eventBean.getDisasterStage().equals("无法解决，申请专家会商")){
                    if(expertEventBean.getResult()!=null &&  expertEventBean.getResult().length()!=0 ){
                        advice = expertEventBean.getResult();
                    }else{
                        advice="与当地相关部门合作配合处理";
                    }
                }else{
                    advice="与当地相关部门合作配合处理";
                }
            }else{
                advice="与当地相关部门合作配合处理";
            }
            eventBean.setAdvice(advice);
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return eventBean;
    }

    @Override
    public void applyCheck(EventBean eventBean) {
        try {
            iEventDao.updateDisasterStage(eventBean);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public int updateEventInfo(EventBean eventBean) {
        SqlSession session = SqlSessionUtil.getSession();
        IEventDao iEventDao = session.getMapper(IEventDao.class);
        try {
            iEventDao.updateEventInfo(eventBean);
            session.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
        return 0;
    }

    @Override
    public int addEvent(EventBean eventBean) {
        try {
            iEventDao.addEvent(eventBean);
            session.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
        return 0;
    }

    @Override
    public int deleteEvent(int id) {
        try {
            iEventDao.deleteEvent(id);
            session.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
        return 0;
    }
}
