package com.project.service.impl;

import com.github.pagehelper.PageInfo;
import com.project.bean.EventBean;
import com.project.bean.ExpertEventBean;
import com.project.dao.IEventDao;
import com.project.dao.IExpertEventDao;
import com.project.service.IExpertEventService;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExpertEventServiceImpl implements IExpertEventService {

    @Override
    public EventBean searchExpertInfo(Integer eventId) throws Exception {
         SqlSession session= SqlSessionUtil.getSession();
         IExpertEventDao iExpertEventDao=session.getMapper(IExpertEventDao.class);
         IEventDao iEventDao=session.getMapper(IEventDao.class);
         List<ExpertEventBean> list = iExpertEventDao.searchExpertInfo(eventId);
         EventBean eventBean = iEventDao.showEventInfo(eventId);
         eventBean.setList(list);
         session.close();
        return eventBean;

    }

    @Override
    public void addExpertInformation(ExpertEventBean expertEventBean) throws Exception {
        SqlSession session= SqlSessionUtil.getSession();
         IExpertEventDao iExpertEventDao=session.getMapper(IExpertEventDao.class);
        IEventDao iEventDao=session.getMapper(IEventDao.class);
          iExpertEventDao.addExpertInformation(expertEventBean);
          session.commit();
          session.close();
    }

    @Override
    public PageInfo<EventBean> findAllExperteventBean(Map<String,String>stringStringMap) {
        SqlSession session= SqlSessionUtil.getSession();
        IExpertEventDao iExpertEventDao=session.getMapper(IExpertEventDao.class);
        IEventDao iEventDao=session.getMapper(IEventDao.class);
        Map<String,String>map=new HashMap<>();
        map.put("type","灾情状态");
        map.put("value","无法解决,申请专家会商");
        List<EventBean>list =iEventDao.findEventByCondition(map);

         PageInfo<EventBean>pageInfo=new PageInfo<>(list);
            return pageInfo;

    }

}
