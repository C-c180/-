package com.project.dao;

import com.project.bean.SpecialistBean;


import com.project.getSql.SpecialistSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface ISpecialistDao {
      @SelectProvider(type = SpecialistSqlProvider.class,method = "getAllSpecialistInformationBystringStringMap")
      @ResultMap("com.project.dao.ISpecialistDao.map.SpecialistMap")
       public List<SpecialistBean> searchSpecialist(Map<String, String> stringStringMap)throws Exception;

    @Insert(value = "INSERT INTO t_specialist(specialistName,workunit,speciality,duty,telphone,birthday,sex,address,email,imgs) values(#{specialistName},#{workunit},#{speciality}," +
            "        #{duty},#{telphone}," +
            "        #{birthday},#{sex}," +
            "        #{address},#{email},#{picture})")
    public void addSpecialistInformation(SpecialistBean specialistBean) throws Exception;

    @Select("SELECT \n" +
            "                     spe.specialistId AS specialistId,\n" +
            "                     spe.birthday AS birthday,\n" +
            "                   spe.sex AS sex,\n" +
            "                    spe.address AS address,\n" +
            "                  spe.email AS email,\n" +
            "                    spe.imgs AS picture ,\n" +
            "                      spe.specialistName AS specialistName,\n" +
            "                      spe.workunit AS workunit,\n" +
            "                     spe.speciality AS speciality,\n" +
            "                     spe.duty AS duty,\n" +
            "                     spe.telphone AS telphone\n" +
            "                FROM t_specialist AS spe WHERE specialistId=#{specialistId};")
    public SpecialistBean getSpecialistInformationById(@Param("specialistId") Integer specialistId) throws Exception;

    @Update("UPDATE t_specialist SET \n" +
            "                      telphone=#{telphone},\n" +
            "                      duty=#{duty},\n" +
            "                     workunit=#{workunit},\n" +
            "                     email=#{email} WHERE specialistId=#{specialistId}")
    public void updateSpecialistInformation(SpecialistBean specialistBean)throws Exception;


    @Delete("delete from t_specialist where specialistId=#{specialistId}")
    public void deleteSpecialistInformation(@Param("specialistId") Integer specialistId)throws Exception;

}
