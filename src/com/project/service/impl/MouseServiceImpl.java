package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.MouseBean;
import com.project.dao.IMouseDao;
import com.project.service.IMouseService;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class MouseServiceImpl implements IMouseService {
    @Override
    public PageInfo<MouseBean> findMouseByCondition(Map<String, String> condition) {
        SqlSession session=SqlSessionUtil.getSession();
        IMouseDao iMouseDao=session.getMapper(IMouseDao.class);
        PageHelper.startPage(Integer.parseInt(condition.get("pageNum")), Integer.parseInt(condition.get("pageSize")));
        List<MouseBean> list = iMouseDao.findMouseByCondition(condition);
        PageInfo<MouseBean> pageInfo=new PageInfo<>(list);
        session.close();
        return pageInfo;
    }

    @Override
    public void addMouse(MouseBean mouseBean) {
        SqlSession session=SqlSessionUtil.getSession();
        IMouseDao iMouseDao=session.getMapper(IMouseDao.class);
        iMouseDao.addMouse(mouseBean);
        session.commit();
        session.close();
    }

    @Override
    public MouseBean findById(int id) {
        SqlSession session=SqlSessionUtil.getSession();
        IMouseDao iMouseDao=session.getMapper(IMouseDao.class);
        MouseBean mouseBean = iMouseDao.findMouseById(id);
        session.close();
        return mouseBean;
    }
}
