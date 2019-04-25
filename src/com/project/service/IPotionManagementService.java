package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.PotionManagementBean;

import java.util.Map;

public interface IPotionManagementService {
    /**
     * 查询药剂
     * @param condition 查询条件
     * @return 分页对象
     */
    public PageInfo<PotionManagementBean> showPotionInfo(Map<String,String> condition);
    /**
     * 添加药剂
     * @param potionManagementBean 药剂对象
     */
    public void addPotion(PotionManagementBean potionManagementBean);
}
