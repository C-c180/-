package com.project.getSql;


import java.util.Map;

public class PotionManagementSqlProvider {
        public String getPotionByCondition(Map<String,String> condition){
            String sql="SELECT potionName,preventCureTypeId,DiseasesAndPestsName,treeSpecies " +
                    "FROM t_potionmanagement WHERE 1=1 ";
            String name = condition.get("name");
            String type = condition.get("type");
            String suitable = condition.get("suitable");
            if(name!=null){
                sql+=" and potionName like '%"+name+"%'";
            }
            if(type!=null) {
                sql+=" and preventCureTypeId ="+type;
            }
            if(suitable!=null){
                sql+=" and DiseasesAndPestsName like '%"+suitable+"%'";
            }
            sql+=" order by id desc ";
            return sql;
        }
}

