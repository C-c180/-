package com.project.service.impl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.LogBean;
import com.project.dao.ILogDao;
import com.project.service.ILogService;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class LogServiceImpl implements ILogService {
    @Override
    public List<LogBean> findAllLog() {
        SqlSession session = SqlSessionUtil.getSession();
        ILogDao iLogDao= session.getMapper(ILogDao.class);
        List<LogBean> allLog = iLogDao.findAllLog();
        session.close();
        return allLog;
    }

    @Override
    public PageInfo<LogBean> findByCondition(Map<String,String> condition) {
        SqlSession session = SqlSessionUtil.getSession();
        ILogDao iLogDao= session.getMapper(ILogDao.class);
        int currentPage=Integer.parseInt(condition.get("currentPage"));
        int pageSize=Integer.parseInt(condition.get("pageSize"));
        PageHelper.startPage(currentPage,pageSize);
        List<LogBean>list=null;
        list=iLogDao.findByCondiction(condition);
        PageInfo<LogBean>page=new PageInfo<LogBean>(list);
        session.close();
        return page;

    }

    @Override
    public List<LogBean> findLogByStartDateAndEndDate(String startDate, String endDate) {
        SqlSession session = SqlSessionUtil.getSession();
        ILogDao iLogDao= session.getMapper(ILogDao.class);
        List<LogBean> logByStartDateAndEndDate = iLogDao.findLogByStartDateAndEndDate(startDate, endDate);
        session.close();
        return logByStartDateAndEndDate;
    }

    @Override
    public void addLog(LogBean bean) {
        SqlSession session = SqlSessionUtil.getSession();
        ILogDao iLogDao= session.getMapper(ILogDao.class);
        iLogDao.addLog(bean);
        session.commit();
        session.close();
    }
}
