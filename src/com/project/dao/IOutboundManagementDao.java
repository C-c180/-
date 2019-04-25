package com.project.dao;

import com.project.bean.CountOutboundBean;
import com.project.bean.OutboundManagementBean;
import com.project.getSql.OutboundManagementSqlProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

public interface IOutboundManagementDao {
    @SelectProvider(type = OutboundManagementSqlProvider.class,method = "getOutboundInformationByCondition")
    @ResultMap("com.project.dao.IOutboundManagementDao.map.outboundMap")
    public List<OutboundManagementBean> showOutboundInfo(Map<String,String> condition);
    @Insert(value = "insert into t_outboundmanagement values (null,#{outboundDate},#{outboundTypeId},#{preventCureTypeId},#{itemName},#{recipientsNum},#{classId},#{mainUse} )")
    public void addOutboundInformation(OutboundManagementBean outboundManagementBean);
    @Select(value = "SELECT outboundTypeId,COUNT(outboundTypeId) as outboundNum FROM t_outboundmanagement GROUP BY outboundTypeId;")
    public List<CountOutboundBean> obtainReportShowData();
}
