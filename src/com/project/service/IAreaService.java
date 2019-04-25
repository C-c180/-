package com.project.service;


import com.github.pagehelper.PageInfo;
import com.project.bean.AreaBean;

import java.util.List;
import java.util.Map;

/**
 * 区域一览业务接口
 */
public interface IAreaService {

    /**
     * 动态条件分页查询区域信息
     * @param condition 条件map集合
     * @return 分页对象
     */
    public PageInfo<AreaBean> findByCondition(Map<String, String> condition);

    /**
     * 添加区域信息
     * @param areaBean 区域对象
     */
    public int addArea(AreaBean areaBean);

    /**
     * 通过区域id查询区域
     * @param areaId 区域id
     */
    public AreaBean findAreaById(int areaId);

    /**
     * 查询所有区域
     */
    public List<AreaBean> findAllArea();
}
