package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.InsectBean;

import java.util.Map;

public interface IInsectService {
    /**
     * 查询虫害
     * @param condition 查询条件
     * @return 返回分页对象
     */
    public PageInfo<InsectBean> findInsectByCondition(Map<String,String> condition);

    /**
     * 添加虫害
     * @param insectBean 虫害实体类
     */
    public void addInsect(InsectBean insectBean);

    /**
     * 根据id查询虫害
     * @param id 虫害id
     * @return 返回虫害对象
     */
    public InsectBean findInsectById(int id);
}
