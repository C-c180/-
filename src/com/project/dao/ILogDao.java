package com.project.dao;
import com.project.bean.LogBean;
import com.project.getSql.LogSqlProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import com.project.getSql.LogSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface ILogDao {
    @Select("select id as id,logContent as logContent,logDate as logDate from t_log")

    public List<LogBean> findAllLog();

    @Select("select id as id,logContent as logContent," +
            "logDate as logDate from t_log " +
            "where logDate>=#{startdate} and logDate<=#{enddate}")
    public List<LogBean> findLogByStartDateAndEndDate(@Param("startdate") String startDate, @Param("enddate") String endDate);

@SelectProvider(type= LogSqlProvider.class,method = "getLogByCondiction")
@ResultMap(value = "com.project.dao.ILogDao.map.logMap")
public List<LogBean> findByCondiction(Map<String,String> condition);

@Insert("insert into t_log(logContent,logDate)values(#{logContent},#{logDate})")
    public void addLog(LogBean baen);
}
