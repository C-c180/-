package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.AreaBean;
import com.project.dao.IAreaDao;
import com.project.service.IAreaService;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class AreaServiceImpl implements IAreaService {

    SqlSession session = SqlSessionUtil.getSession();
    IAreaDao iAreaDao = session.getMapper(IAreaDao.class);

    @Override
    public PageInfo<AreaBean> findByCondition(Map<String, String> condition) {

        int currentPage = Integer.parseInt(condition.get("currentPage"));
        int pageSize = Integer.parseInt(condition.get("pageSize"));
        PageHelper.startPage(currentPage,pageSize);
        List<AreaBean> list = iAreaDao.findAreaByCondition(condition);
        PageInfo<AreaBean> page = new PageInfo<AreaBean>(list);
        session.close();
        return page;
    }

    @Override
    public int addArea(AreaBean areaBean) {

        try {
            iAreaDao.addArea(areaBean);
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
    public AreaBean findAreaById(int areaId) {
        AreaBean areaBean = iAreaDao.findAreaById(areaId);
        session.close();
        return areaBean;
    }

    @Override
    public List<AreaBean> findAllArea() {
        return iAreaDao.findAllArea();
    }
}
