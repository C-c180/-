package com.project.getSql;

import java.util.Map;

public class OutboundManagementSqlProvider {
    public String getOutboundInformationByCondition(Map<String,String> condition){
        String sql="SELECT o.outboundId,o.outboundDate,o.itemName,o.mainUse,o.recipientsNum,c.className " +
                "FROM t_outboundmanagement AS o LEFT JOIN t_class AS c ON o.classId=c.id " +
                "where 1=1 ";
        String startDate = condition.get("startDate");
        String endDate = condition.get("endDate");
        if(startDate!=null){
            sql+=" and outboundDate>'"+startDate+"'";
        }
        if(endDate!=null){
            sql+=" and outboundDate<'"+endDate+"'";
        }
        sql+=" order by o.outboundId desc ";
        return sql;
    }
}
