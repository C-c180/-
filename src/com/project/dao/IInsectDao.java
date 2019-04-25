package com.project.dao;

import com.project.bean.InsectBean;
import com.project.getSql.SelectSql;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface IInsectDao {
    @SelectProvider(type = SelectSql.class,method = "getInsectSql")
    @ResultMap("insectDao.findInsectByCondition")
    public List<InsectBean> findInsectByCondition(Map<String,String> condition);
    @Insert("INSERT INTO t_insect(insectName," +
            "hostName," +
            "breed," +
            "enemy," +
            "controlling," +
            "danger," +
            "childPicture," +
            "insectPicture) \n" +
            "VALUES(#{name},#{hostName},#{breed},#{enemy},#{controlling},#{danger},#{childPicture},#{insectPicture})")
    public void addInsect(InsectBean insectBean);
    @Select("SELECT id AS id," +
            "insectName AS NAME," +
            "hostName AS hostName," +
            "breed AS breed," +
            "enemy AS enemy," +
            "controlling AS controlling," +
            "danger AS danger," +
            "childPicture AS childPicture," +
            "insectPicture AS insectPicture\n" +
            "FROM t_insect where id =#{insectId}")
    @ResultMap("insectDao.findInsectByCondition")
    public InsectBean findInsectById(@Param("insectId") int id);
}
