package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.CountOutboundBean;
import com.project.bean.OutboundManagementBean;

import java.util.List;
import java.util.Map;

public interface IOutboundManagementService {
    /**
     * 查询出库信息
     * @param condition 查询条件
     * @return 返回分页对象
     */
    public PageInfo<OutboundManagementBean> showOutboundInfo(Map<String,String> condition);

    /**
     * 添加出库信息
     * @param outboundManagementBean 出库对象
     */
    public void addOutboundInformation(OutboundManagementBean outboundManagementBean);

    /**
     * 查询全部出库信息
     * @return 出库信息对象的集合
     */
    public List findAllOutbound();

    /**
     * 报表需要的出库药剂和器械的出库数量
     * @return 返回两个数字，分别是药剂和器械
     */
    public List<CountOutboundBean> obtainReportShowData();
}
