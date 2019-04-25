package com.project.dao;


import com.project.bean.AreaBean;
import com.project.getSql.AreaSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 区域一览持久接口
 */
public interface IAreaDao {

    @SelectProvider(type= AreaSqlProvider.class,method ="getAreaByCondition")
    @ResultMap("com.project.dao.IAreaDao.map.areaMap")
    public List<AreaBean> findAreaByCondition(Map<String, String> condition);


    @Insert("insert into t_area(areaName,forestType,landType,dominantTree)" +
            "values(#{areaName},#{forestType},#{landType},#{dominantTree})")
    public void addArea(AreaBean areaBean);


    @SelectProvider(type= AreaSqlProvider.class,method ="getAreaById")
    @ResultMap("com.project.dao.IAreaDao.map.areaMap")
    public AreaBean findAreaById(int areaId);


    @Select("select * from t_area")
    @ResultMap("com.project.dao.IAreaDao.map.areaMap")
    public List<AreaBean> findAllArea();
}
