package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.ClassBean;

import java.util.Map;

/**
 * 小班管理业务接口
 */
public interface IClassService {

    /**
     * 动态条件分页查询班级
     * @param condition 条件集合
     * @return 分页对象
     */
    public PageInfo<ClassBean> findClassByCondition(Map<String, String> condition);

    /**
     * 添加小级
     * @param classBean 小班对象
     */
    public int addClass(ClassBean classBean);

    /**
     * 根据小班id查看小班信息
     * @param classId 小班id
     * @return 小班对象
     */
    public ClassBean showClassInfoById(int classId);

    /**
     * 根据小班id修改小班信息
     * @param classBean 小班对象
     */
    public int updateClassInfo(ClassBean classBean);
}
