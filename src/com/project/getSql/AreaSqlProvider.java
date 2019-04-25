package com.project.getSql;

import java.util.Map;

/**
 * 区域sqlProvider类
 */
public class AreaSqlProvider {

    public String getAreaByCondition(Map<String,String> condition){

        String sql = "select area.id,areaName,forestType,landType,dominantTree," +
                " cls.id,className,principal,principalTel from t_area as area left join t_class as cls" +
                " on area.id = cls.areaId where 1=1";
        String type = condition.get("type");
        String vaule = condition.get("value");
        if(vaule!=null&& ("区域名称").equals(type)){
            sql+=" and areaName like '%"+vaule+"%'";
        }else if(vaule!=null&&("林种").equals(type)){
            sql+=" and forestType like '%"+vaule+"%'";
        }
        sql+=" ORDER BY area.id DESC";
        return sql;
    }
    public String getAreaById(int areaId){

        String sql = "select area.id,areaName,forestType,landType,dominantTree," +
                " cls.id,className,principal,principalTel from t_area as area left join t_class as cls" +
                " on area.id = cls.areaId where area.id="+areaId;
        return sql;
    }
}
