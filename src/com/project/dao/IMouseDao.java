package com.project.dao;

import com.project.bean.MouseBean;
import com.project.getSql.SelectSql;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface IMouseDao {
    @SelectProvider(type = SelectSql.class,method = "getMouseSql")
    @ResultType(MouseBean.class)
    public List<MouseBean> findMouseByCondition(Map<String,String> condition);
    @Insert("INSERT INTO t_mouse(mouseName,food,breed,enemy,measure,mainDanger,picture) \n" +
            "VALUES(#{name},#{food},#{breed},#{enemy},#{measure},#{mainDanger},#{picture})")
    public void addMouse(MouseBean mouseBean);
    @Select("SELECT id AS id," +
            "mouseName AS NAME," +
            "food AS food," +
            "breed AS breed," +
            "enemy AS enemy," +
            "measure AS measure," +
            "mainDanger AS mainDanger," +
            "picture AS picture FROM t_mouse where id=#{mouseId}")
    public MouseBean findMouseById(@Param("mouseId") int id);
}
