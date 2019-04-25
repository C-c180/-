package com.project.getSql;

import java.util.Map;

public class SelectSql {
    public String getInsectSql(Map<String,String> codition){
        String sql="SELECT id AS id," +
                "insectName AS NAME," +
                "hostName AS hostName," +
                "breed AS breed," +
                "enemy AS enemy," +
                "controlling AS controlling," +
                "danger AS danger," +
                "childPicture AS childPicture," +
                "insectPicture AS insectPicture\n" +
                "FROM t_insect where 1=1 ";
        String insectName=codition.get("insectName");
        String hostName=codition.get("hostName");
        if (insectName != null && insectName.length() != 0) {
            sql+="and insectName like "+insectName;
        }
        if (hostName != null && hostName.length() != 0) {
            sql+=" and hostName like "+hostName;
        }
        sql+=" order by id desc";
        return sql;
    }
    public String getDiseaseSql(Map<String,String> condition){
         String sql="SELECT id AS id, " +
                 "diseaseName AS NAME," +
                 "pathogeny AS pathogeny," +
                 "symptom AS symptom," +
                 "rule AS rule," +
                 "mainDanger AS mainDanger," +
                 "measure AS measure," +
                 "picture AS picture FROM t_disease where 1=1 ";
         String diseaseName=condition.get("diseaseName");
         String mainDanger=condition.get("mainDanger");
        if (diseaseName != null && diseaseName.length() != 0) {
            sql+="and diseaseName like "+diseaseName;
        }
        if (mainDanger != null && mainDanger.length() != 0) {
            sql+="and mainDanger like "+mainDanger;
        }
        sql+=" order by id desc";
        return sql;
    }
    public String getMouseSql(Map<String,String> conditiion){
        String sql="SELECT id AS id," +
                "mouseName AS NAME," +
                "food AS food," +
                "breed AS breed," +
                "enemy AS enemy," +
                "measure AS measure," +
                "mainDanger AS mainDanger," +
                "picture AS picture FROM t_mouse where 1=1";
        String name = conditiion.get("name");
        if (name != null && name.length() != 0) {
            sql+=" and mouseName like "+name;
        }
        sql+=" order by id desc";
        return sql;
    }
}
