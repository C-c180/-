package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.MechanicalManagementBean;
import com.project.dao.IMechanicalManagementDao;
import com.project.service.IMechanicalManagementService;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class MechanicalManagementServiceImpl implements IMechanicalManagementService {
    SqlSession session = SqlSessionUtil.getSession();
    IMechanicalManagementDao iMechanicalManagementDao=session.getMapper(IMechanicalManagementDao.class);
    @Override
    public PageInfo<MechanicalManagementBean> showMechanicalInfo(Map<String, String> condition) {
        int currentPage = Integer.parseInt(condition.get("currentPage"));
        int pageSize = Integer.parseInt(condition.get("pageSize"));
        PageHelper.startPage(currentPage,pageSize);
        List<MechanicalManagementBean> list = iMechanicalManagementDao.showMechanicalInfo(condition);
        for (MechanicalManagementBean bean:list) {
            if (bean.getPreventCureTypeId() == 1) {
                bean.setPreventCureName("病害");
            }
            if (bean.getPreventCureTypeId() == 2) {
                bean.setPreventCureName("虫害");
            }
            if (bean.getPreventCureTypeId() == 3) {
                bean.setPreventCureName("鼠害");
            }
        }
        PageInfo<MechanicalManagementBean> page = new PageInfo<MechanicalManagementBean>(list);
        return page;
    }

    @Override
    public void addMechanical(MechanicalManagementBean mechanicalManagementBean) {
        try {
            iMechanicalManagementDao.addMechanical(mechanicalManagementBean);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }
}
