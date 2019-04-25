package com.project.dao;

import com.project.bean.MechanicalManagementBean;
import com.project.getSql.MechanicalManagementSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface IMechanicalManagementDao {
    @SelectProvider(type = MechanicalManagementSqlProvider.class,method = "getMechanicalByCondition")
    @ResultMap("com.project.dao.IMechanicalManagementDao.map.mechanicalMap")
    public List<MechanicalManagementBean> showMechanicalInfo(Map<String,String> condition);
    @Insert(value = "insert into t_mechanicalmanagement() values (null,#{mechanicalName},#{preventCureTypeId},#{mainUse})")
    public void addMechanical(MechanicalManagementBean mechanicalManagementBean);
}
