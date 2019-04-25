package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.InsectBean;
import com.project.dao.IInsectDao;
import com.project.service.IInsectService;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class InsectServiceImpl implements IInsectService {
    //private SqlSession session=null;
    //private IInsectDao iInsectDao= null;
    //{
    //    session = SqlSessionUtil.getSession();
    //    iInsectDao = session.getMapper(IInsectDao.class);
    //}
    @Override
    public PageInfo<InsectBean> findInsectByCondition(Map<String, String> condition) {
        SqlSession session=SqlSessionUtil.getSession();
        IInsectDao iInsectDao=session.getMapper(IInsectDao.class);
        PageHelper.startPage(Integer.parseInt(condition.get("pageNum")),Integer.parseInt(condition.get("pageSize")));
        List<InsectBean> list = iInsectDao.findInsectByCondition(condition);
        PageInfo<InsectBean> pageInfo=new PageInfo<InsectBean>(list);
        session.close();
        return pageInfo;
    }

    @Override
    public void addInsect(InsectBean insectBean) {
        SqlSession session=SqlSessionUtil.getSession();
        IInsectDao iInsectDao=session.getMapper(IInsectDao.class);
        iInsectDao.addInsect(insectBean);
        session.commit();
        session.close();
    }

    @Override
    public InsectBean findInsectById(int id) {
        SqlSession session=SqlSessionUtil.getSession();
        IInsectDao iInsectDao=session.getMapper(IInsectDao.class);
        InsectBean insectBean = iInsectDao.findInsectById(id);
        session.close();
        return insectBean;
    }
}
