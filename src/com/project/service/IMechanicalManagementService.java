package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.MechanicalManagementBean;

import java.util.Map;

public interface IMechanicalManagementService {
    /**
     * 查询器械
     * @param condition 查询条件
     * @return 返回分页对象
     */
    public PageInfo<MechanicalManagementBean> showMechanicalInfo(Map<String,String> condition);

    /**
     * 添加机械
     * @param mechanicalManagementBean 机械对象
     */
    public void addMechanical(MechanicalManagementBean mechanicalManagementBean);
}
