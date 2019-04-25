package com.project.service;


import com.github.pagehelper.PageInfo;
import com.project.bean.SpecialistBean;

import java.util.Map;

public interface ISpecialistService {
    /**
     * 查询专家
     * @param condition 查询条件
     * @return 返回
     * @throws Exception
     */
    public PageInfo<SpecialistBean> findSpecialistByCondition(Map<String, String> condition)throws Exception;
    /**
     * 添加专家
     * @param specialistBean 专家对象
     */
    public void addSpecialistInformation(SpecialistBean specialistBean) throws Exception;

    /**
     * 根据专家Id查看专家信息
     * @param specialistId 专家Id
     * @return 专家对象
     * @throws Exception
     */
    public SpecialistBean getSpecialistInformationById(Integer specialistId) throws Exception;

    /**
     * 修改专家信息
     * @param specialistBean 专家对象
     * @throws Exception
     */
    public void updateSpecialistInformation(SpecialistBean specialistBean)throws Exception;

    /**
     * 根据专家Id删除专家
     * @param specialistId 专家Id
     * @throws Exception
     */
    public void deleteSpecialistInformation(Integer specialistId)throws Exception;


}
