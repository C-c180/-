package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.PotionManagementBean;
import com.project.dao.IPotionManagementDao;
import com.project.service.IPotionManagementService;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class PotionManagementServiceImpl implements IPotionManagementService {
    SqlSession session = SqlSessionUtil.getSession();
    IPotionManagementDao iPotionManagementDao=session.getMapper(IPotionManagementDao.class);
    @Override
    public PageInfo<PotionManagementBean> showPotionInfo(Map<String, String> condition) {
        int currentPage = Integer.parseInt(condition.get("currentPage"));
        int pageSize = Integer.parseInt(condition.get("pageSize"));
        PageHelper.startPage(currentPage,pageSize);
        List<PotionManagementBean> list = iPotionManagementDao.showPotionInfo(condition);
        for (PotionManagementBean bean:list) {
            if(bean.getPreventCureTypeId()==1){
                bean.setPreventCureType("病害");
            }
            if(bean.getPreventCureTypeId()==2){
                bean.setPreventCureType("虫害");
            }
            if(bean.getPreventCureTypeId()==3){
                bean.setPreventCureType("鼠害");
            }
        }
        PageInfo<PotionManagementBean> page = new PageInfo<PotionManagementBean>(list);
        return page;
    }

    @Override
    public void addPotion(PotionManagementBean potionManagementBean) {
        try {
            iPotionManagementDao.addPotion(potionManagementBean);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }
    }
}
