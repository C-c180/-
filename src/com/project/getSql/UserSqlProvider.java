package com.project.getSql;

import java.util.Map;

public class UserSqlProvider {
    public String getUserByCondition(Map<String,String> condition){

        String sql="select id,userName,pwd,realName,userScaleId from t_user " +
                "where 1=1 ";
        String userScaleId = condition.get("userScaleId");
        if (userScaleId != null && userScaleId.length() != 0) {
            sql+=" and userScaleId="+userScaleId;
        }
         sql+="  order by id desc";
        return sql;
    }
}
