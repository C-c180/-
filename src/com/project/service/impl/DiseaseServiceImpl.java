package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.DiseaseBean;
import com.project.dao.IDiseaseDao;
import com.project.service.IDiseaseService;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class DiseaseServiceImpl implements IDiseaseService {
    @Override
    public PageInfo<DiseaseBean> findDiseaseByCondition(Map<String, String> condition) {
        SqlSession session=SqlSessionUtil.getSession();
        IDiseaseDao iDiseaseDao=session.getMapper(IDiseaseDao.class);
        PageHelper.startPage(Integer.parseInt(condition.get("pageNum")), Integer.parseInt(condition.get("pageSize")));
        List<DiseaseBean> list = iDiseaseDao.findDiseaseByCondition(condition);
        PageInfo<DiseaseBean> pageInfo=new PageInfo<DiseaseBean>(list);
        session.close();
        return pageInfo;
    }

    @Override
    public void addDiease(DiseaseBean diseaseBean) {
        SqlSession session=SqlSessionUtil.getSession();
        IDiseaseDao iDiseaseDao=session.getMapper(IDiseaseDao.class);
        iDiseaseDao.addDisease(diseaseBean);
        session.commit();
        session.close();
    }

    @Override
    public DiseaseBean findById(int id) {
        SqlSession session=SqlSessionUtil.getSession();
        IDiseaseDao iDiseaseDao=session.getMapper(IDiseaseDao.class);
        DiseaseBean diseaseBean = iDiseaseDao.findDiseaseId(id);
        session.close();
        return diseaseBean;
    }
}
