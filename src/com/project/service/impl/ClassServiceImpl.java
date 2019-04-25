package com.project.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.ClassBean;
import com.project.dao.IClassDao;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class ClassServiceImpl implements com.project.service.IClassService {

    SqlSession session = SqlSessionUtil.getSession();
    IClassDao iClassDao = session.getMapper(IClassDao.class);
    @Override
    public PageInfo<ClassBean> findClassByCondition(Map<String, String> condition) {
        int currentPage = Integer.parseInt(condition.get("currentPage"));
        int pageSize = Integer.parseInt(condition.get("pageSize"));
        PageHelper.startPage(currentPage,pageSize);
        List<ClassBean>list = iClassDao.findClassByCondition(condition);
        PageInfo<ClassBean> page = new PageInfo<ClassBean>(list);
        session.close();
        return page;
    }

    @Override
    public int addClass(ClassBean classBean) {
        try {
            iClassDao.addClass(classBean);
            session.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
        return 0;
    }

    @Override
    public ClassBean showClassInfoById(int classId) {
        return iClassDao.showClassInfo(classId);
    }

    @Override
    public int updateClassInfo(ClassBean classBean) {
        SqlSession session = SqlSessionUtil.getSession();
        IClassDao iClassDao = session.getMapper(IClassDao.class);
        try {
            iClassDao.updateClassInfo(classBean);
            session.commit();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
        return 0;
    }
}
