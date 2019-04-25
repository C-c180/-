package com.project.dao;

import com.project.bean.ExpertEventBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IExpertEventDao {
     @Select(value = " SELECT e.experteventId,e.eventId,e.dataTime,e.result,e.staff  FROM t_expertevent AS e WHERE eventId=#{eventId} order by experteventId desc")
    public List<ExpertEventBean> searchExpertInfo(@Param("eventId") Integer eventId);


    @Insert("insert into t_expertevent values(null,#{dataTime},#{staff},#{result},#{eventId})")
    public void addExpertInformation(ExpertEventBean expertEventBean);

}
