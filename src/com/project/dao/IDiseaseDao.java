package com.project.dao;

import com.project.bean.DiseaseBean;
import com.project.getSql.SelectSql;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface IDiseaseDao {
    @SelectProvider(type = SelectSql.class,method = "getDiseaseSql")
    @ResultType(DiseaseBean.class)
    public List<DiseaseBean> findDiseaseByCondition(Map<String,String> condition);
    @Insert("INSERT INTO t_disease(diseaseName,pathogeny,symptom,rule,mainDanger,measure,picture) \n" +
            "VALUES(#{name},#{pathogeny},#{symptom},#{rule},#{mainDanger},#{measure},#{picture})")
    public void addDisease(DiseaseBean diseaseBean);
    @Select("SELECT id AS id, " +
            "diseaseName AS NAME," +
            "pathogeny AS pathogeny," +
            "symptom AS symptom," +
            "rule AS rule," +
            "mainDanger AS mainDanger," +
            "measure AS measure," +
            "picture AS picture FROM t_disease where id=#{diseaseId}")
    public DiseaseBean findDiseaseId(@Param("diseaseId") int id);
}
