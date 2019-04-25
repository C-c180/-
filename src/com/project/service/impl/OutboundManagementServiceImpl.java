package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.ClassBean;
import com.project.bean.CountOutboundBean;
import com.project.bean.OutboundManagementBean;
import com.project.dao.IClassDao;
import com.project.dao.IOutboundManagementDao;
import com.project.service.IOutboundManagementService;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutboundManagementServiceImpl implements IOutboundManagementService {
    @Override
    public PageInfo<OutboundManagementBean> showOutboundInfo(Map<String, String> condition) {
        SqlSession session = SqlSessionUtil.getSession();
        IOutboundManagementDao iOutboundManagementDao=session.getMapper(IOutboundManagementDao.class);
        int currentPage = Integer.parseInt(condition.get("currentPage"));
        int pageSize = Integer.parseInt(condition.get("pageSize"));
        PageHelper.startPage(currentPage,pageSize);
        List<OutboundManagementBean> list = iOutboundManagementDao.showOutboundInfo(condition);
        PageInfo<OutboundManagementBean> page = new PageInfo<OutboundManagementBean>(list);
        session.close();
        return page;
    }

    @Override
    public void addOutboundInformation(OutboundManagementBean outboundManagementBean) {
        SqlSession session = SqlSessionUtil.getSession();
        IOutboundManagementDao iOutboundManagementDao=session.getMapper(IOutboundManagementDao.class);
        try {
            iOutboundManagementDao.addOutboundInformation(outboundManagementBean);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List findAllOutbound() {
        SqlSession session = SqlSessionUtil.getSession();
        IClassDao iClassDao = session.getMapper(IClassDao.class);
        Map map =new HashMap();
        List<ClassBean> list= iClassDao.findClassByCondition(map);
        session.close();
        return list;
    }

    @Override
    public List<CountOutboundBean> obtainReportShowData() {
        SqlSession session = SqlSessionUtil.getSession();
        IOutboundManagementDao iOutboundManagementDao=session.getMapper(IOutboundManagementDao.class);
        List<CountOutboundBean> list=iOutboundManagementDao.obtainReportShowData();
        for (CountOutboundBean countOutboundBean : list) {
            if(countOutboundBean.getOutboundTypeId()==1){
                countOutboundBean.setOutboundType("药剂");
            }
            if(countOutboundBean.getOutboundTypeId()==2){
                countOutboundBean.setOutboundType("器械");
            }
        }
        return list;
    }
}
