package com.project.getSql;

import java.util.Map;

public class SpecialistSqlProvider {
    public String getAllSpecialistInformationBystringStringMap(Map<String, String> stringStringMap){
        String sql="select spe.specialistId as specialistId," +
                "          spe.specialistName as specialistName," +
                "          spe.workunit as workunit," +
                "          spe.speciality as speciality," +
                "          spe.duty as duty," +
                "          spe.telphone as telphone " +
                "   from t_specialist as spe where 1=1 ";
        String specialistName=stringStringMap.get("specialistName");
        String speciality=stringStringMap.get("speciality");
        String workunit=stringStringMap.get("workunit");


      if(specialistName!=null&&specialistName.length()!=0){
          sql+=" and spe.specialistName like "+"'%"+specialistName+"%' ";
      }
      if(workunit!=null&&workunit.length()!=0){
          sql+=" and spe.workunit='"+workunit+"' ";
      }
      if(speciality!=null&&speciality.length()!=0){
          sql+=" and spe.speciality='"+speciality+"' ";
      }
      sql+=" order by specialistId desc";
      return sql;
    }
}
