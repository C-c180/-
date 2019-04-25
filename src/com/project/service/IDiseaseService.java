package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.DiseaseBean;

import java.util.Map;

public interface IDiseaseService {
    /**
     * 查询病害
     * @param condition 查询病害条件
     * @return 返回分页对象
     */
    public PageInfo<DiseaseBean> findDiseaseByCondition(Map<String,String> condition);

    /**
     * 添加病害
     * @param diseaseBean 病害对象
     */
    public void addDiease(DiseaseBean diseaseBean);

    /**
     * 根据id查询病害
     * @param id 病害id
     * @return 返回病害实体对象
     */
    public DiseaseBean findById(int id);
}
