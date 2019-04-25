package com.project.dao;


import com.project.bean.EventBean;
import com.project.getSql.EventSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 事件对象持久接口
 */
public interface IEventDao {


    @SelectProvider(type = EventSqlProvider.class,method ="getEventByCondition")
    @ResultMap("com.project.dao.IEventDao.map.EventMap")
    public List<EventBean> findEventByCondition(Map<String, String> condition);

    @SelectProvider(type = EventSqlProvider.class,method ="getEventById")
    @ResultMap("com.project.dao.IEventDao.map.EventMap")
    public EventBean showEventInfo(int eventId);


    @Update("update t_event set disasterStage=#{disasterStage}" +
            "               where id = #{id}")
    public void updateDisasterStage(EventBean eventBean);


    @Update("update t_event set disasterStage=#{disasterStage}," +
            "               PreventPlan=#{PreventPlan} " +
            "               where id = #{id}")
    public void updateEventInfo(EventBean eventBean);

    @InsertProvider(type = EventSqlProvider.class,method ="addEvent")
    public void addEvent(EventBean eventBean);

    @Delete("delete from t_event where id =#{eventId}")
    public void deleteEvent(@Param("eventId") int id);
}
