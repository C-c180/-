package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.SpecialistBean;
import com.project.dao.ISpecialistDao;
import com.project.service.ISpecialistService;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class SpecialistServiceImpl implements ISpecialistService {

    @Override
    public PageInfo<SpecialistBean> findSpecialistByCondition(Map<String, String> condition) throws Exception {
        SqlSession session= SqlSessionUtil.getSession();
        ISpecialistDao iSpecialistDao= session.getMapper(ISpecialistDao.class);
     int currentPage=Integer.parseInt(condition.get("currentPage"));
       int pageSize=Integer.parseInt(condition.get("pageSize"));
        PageHelper.startPage(currentPage,pageSize);
        List<SpecialistBean>list=iSpecialistDao.searchSpecialist(condition);
        PageInfo<SpecialistBean>page=new PageInfo<>(list);
        return page;
    }

    @Override
    public void addSpecialistInformation(SpecialistBean specialistBean) throws Exception {
        SqlSession session= SqlSessionUtil.getSession();
        ISpecialistDao iSpecialistDao= session.getMapper(ISpecialistDao.class);
            iSpecialistDao.addSpecialistInformation(specialistBean);
            session.commit();
            session.close();
    }

    @Override
    public SpecialistBean getSpecialistInformationById(Integer specialistId) throws Exception {
        SqlSession session= SqlSessionUtil.getSession();
        ISpecialistDao iSpecialistDao= session.getMapper(ISpecialistDao.class);
        return iSpecialistDao.getSpecialistInformationById(specialistId);
    }

    @Override
    public void updateSpecialistInformation(SpecialistBean specialistBean) throws Exception {
        SqlSession session= SqlSessionUtil.getSession();
        ISpecialistDao iSpecialistDao= session.getMapper(ISpecialistDao.class);
               iSpecialistDao.updateSpecialistInformation(specialistBean);
               session.commit();
               session.close();
    }

    @Override
    public void deleteSpecialistInformation(Integer specialistId) throws Exception {
        SqlSession session= SqlSessionUtil.getSession();
        ISpecialistDao iSpecialistDao= session.getMapper(ISpecialistDao.class);
           iSpecialistDao.deleteSpecialistInformation(specialistId);
           session.commit();
           session.close();

    }
}
