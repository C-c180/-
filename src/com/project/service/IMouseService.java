package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.MouseBean;

import java.util.Map;

public interface IMouseService {
    /**
     * 查询鼠害
     * @param condition 查询条件
     * @return 返回分页对象
     */
    public PageInfo<MouseBean> findMouseByCondition(Map<String,String> condition);

    /**
     * 添加鼠害
     * @param mouseBean 鼠害对象
     */
    public void addMouse(MouseBean mouseBean);

    /**
     * 根据id查询鼠害对象
     * @param id 鼠害id
     * @return 返回鼠害对象
     */
    public MouseBean findById(int id);
}
