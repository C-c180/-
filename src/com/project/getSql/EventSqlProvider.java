package com.project.getSql;

import com.project.bean.EventBean;

import java.util.Map;

/**
 * 事件sqlProvider类
 */
public class EventSqlProvider {

    public String getEventByCondition (Map<String,String> condition){
        String sql="select evet.id,eventName,dateTimes,disasterStage,disasterDesc,loss,PreventPlan," +
                " imagePath,disastersType,foundWay,AreaOfInfluence,ae.areaName,className from " +
                " t_event as evet left join t_area as areas on evet.areaId = areas.id," +
                " t_class as cls left join t_area as ae on cls.areaId = ae.id where evet.areaId = cls.areaId";
        String type = condition.get("type");
        String value = condition.get("value");
        String startDate = condition.get("startDate");
        String endDate = condition.get("endDate");
        if(value!=null && ("事件名称").equals(type)){
            sql += " and eventName like '%"+value+"%'";
        }else if(value!=null && ("灾情状态").equals(type)){
            sql += " and disasterStage like '%"+value+"%'";
        }else if(value!=null && ("发生位置").equals(type)){
            sql += " and ae.areaName like '%"+value+"%'";
        }
        if(startDate!=null && startDate.length()!=0){
            sql+=" and dateTimes>'"+startDate+"'";
        }
        if(endDate!=null && endDate.length()!=0){
            sql+=" and dateTimes<'"+endDate+"'";
        }
        sql+=" ORDER BY evet.id DESC";
        return sql;
    }

    public String getEventById (int eventId){
        String sql="select event.id,eventName,dateTimes,disasterStage,disasterDesc,loss,PreventPlan," +
                " imagePath,disastersType,foundWay,AreaOfInfluence,ae.areaName,cls.className from " +
                " t_event as event left join t_area as areas on event.areaId = areas.id," +
                " t_class as cls left join t_area as ae on cls.areaId = ae.id where event.id="+eventId+" " +
                " and event.areaId = cls.areaId";
        return sql;
    }



    public String addEvent(EventBean eventBean){

        String name = eventBean.getEventName();
        String dateTimes = eventBean.getDateTimes();
        String disasterStage = eventBean.getDisasterStage();
        String disasterDesc = eventBean.getDisasterDesc();
        double loss = eventBean.getLoss();
        String preventPlan = eventBean.getPreventPlan();
        String img = eventBean.getImagePath();
        String disaterType = eventBean.getDisastersType();
        String foundway = eventBean.getFoundWay();
        double areaInfluence = eventBean.getAreaOfInfluence();
        int areaId = eventBean.getHappenPlace().getId();
        eventBean.getHappenPlace();
        String sql="insert into t_event(eventName,dateTimes,disasterStage,disasterDesc," +
                "areaId,loss,PreventPlan,imagePath,disastersType,FoundWay,AreaOfInfluence)" +
                "values('"+name+"','"+dateTimes+"','"+disasterStage+"','"+disasterDesc+"'," +
                ""+areaId+ ","+loss+",'"+preventPlan+"','"+img+"','"+disaterType+"','"+foundway+"',"+
                ""+areaInfluence+")";
        return  sql;
    }
}
