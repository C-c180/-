package com.project.getSql;

import java.util.Map;

/**
 * 小班sqlProvider类
 */
public class ClassSqlProvider {

    public String getClassByCondition(Map<String,String> condition){
        String sql = "select cls.id,personNum,creatDate,className,principal,principalTel,areaName from" +
                " t_class as cls left join t_area as area on cls.areaId=area.id" +
                " where 1=1";
        String type = condition.get("type");
        String value = condition.get("value");
        if(value!=null && ("小班名称").equals(type)){
            sql+=" and className like '%"+value+"%'";
        }else if(value!=null && ("负责区域").equals(type)){
            sql+=" and area.areaName like '%"+value+"%'";
        }
        sql+=" ORDER BY cls.id DESC";
        return  sql;
    }

}
