package com.project.dao;

import com.project.bean.PotionManagementBean;
import com.project.getSql.PotionManagementSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface IPotionManagementDao {
    @SelectProvider(type = PotionManagementSqlProvider.class,method = "getPotionByCondition")
    @ResultMap("com.project.dao.IPotionManagementDao.map.potionMap")
    public List<PotionManagementBean> showPotionInfo(Map<String,String> condition);
    @Insert(value = "insert into t_potionmanagement values (null,#{potionName},#{preventCureTypeId},#{diseasesAndPestsName},#{treeSpecies})")
    public void addPotion(PotionManagementBean potionManagementBean);
}
