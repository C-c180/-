package com.project.getSql;

import java.util.Map;

public class MechanicalManagementSqlProvider {
    public String getMechanicalByCondition(Map<String,String> condition){
        String sql="SELECT mechanicalId,mechanicalName,preventCureTypeId,mainUse " +
                "FROM t_mechanicalmanagement WHERE 1=1";
        String name = condition.get("name");
        String type = condition.get("type");
        if(name!=null){
            sql+=" and mechanicalName like '%"+name+"%'";
        }
        if(type!=null){
            sql+=" and preventCureTypeId ="+type;
        }
        sql+=" order by mechanicalId desc ";
        return sql;
    }
}
