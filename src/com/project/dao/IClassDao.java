package com.project.dao;


import com.project.bean.ClassBean;
import com.project.getSql.ClassSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * 小班管理持久接口
 */
public interface IClassDao {

    @SelectProvider(type = ClassSqlProvider.class,method = "getClassByCondition")
    @ResultMap("com.project.dao.IClassDao.map.classMap")
    public List<ClassBean> findClassByCondition(Map<String, String> condition);


    @Insert("insert into t_class(className,personNum,creatDate,principal,principalTel,areaId)" +
            "values(#{clazzName},#{personNum},#{creatDate},#{principal},#{principalTel},#{chargeOfArea.id})")
    public void addClass(ClassBean classBean);


    @Select("select cls.id,className,principal,principalTel," +
            " personNum,ae.areaName,forestType,landType," +
            " dominantTree,creatDate" +
            " from t_class as cls left join t_area as ae" +
            " on cls.areaId = ae.id where cls.id=#{classId} ")
    @ResultMap("com.project.dao.IClassDao.map.classMap")
    public ClassBean showClassInfo(@Param("classId") int classId);


    @Update("update t_class set principal=#{principal}," +
            "               principalTel=#{principalTel} " +
            "               where id=#{id}")
    public void updateClassInfo(ClassBean classBean);
}
