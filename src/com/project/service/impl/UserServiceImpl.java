package com.project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.project.bean.UserBean;
import com.project.dao.IUserDao;
import com.project.service.IUserService;
import com.project.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements IUserService {
    @Override
    public UserBean login(String userName,String pwd) {
        SqlSession session = SqlSessionUtil.getSession();
        IUserDao iUserDao = session.getMapper(IUserDao.class);
        UserBean user=null;
        try {
            user=iUserDao.login(userName,pwd);
            if(user!=null){
                if(user.getUserScaleId()==0){
                    user.setUserScale("超级管理员");
                }
                if(user.getUserScaleId()==1){
                    user.setUserScale("资料管理员");
                }
                if(user.getUserScaleId()==2){
                    user.setUserScale("灾情管理员");
                }
                if(user.getUserScaleId()==3){
                    user.setUserScale("专家管理员");
                }
                if(user.getUserScaleId()==4){
                    user.setUserScale("库房管理员");
                }
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        session.close();
        return user;
    }

    @Override
    public PageInfo<UserBean> findByCondition(Map<String, String> condition) {
        SqlSession session = SqlSessionUtil.getSession();
        IUserDao iUserDao = session.getMapper(IUserDao.class);
        int currentPage=Integer.parseInt(condition.get("currentPage"));
        int pageSize=Integer.parseInt(condition.get("pageSize"));
        PageHelper.startPage(currentPage,pageSize);
        List<UserBean>list=null;
        try {
            list=iUserDao.findUserCondition(condition);
            for (UserBean user: list) {
                if(user.getUserScaleId()==0){
                    user.setUserScale("超级管理员");
                }
                if(user.getUserScaleId()==1){
                    user.setUserScale("资料管理员");
                }
                if(user.getUserScaleId()==2){
                    user.setUserScale("灾情管理员");
                }
                if(user.getUserScaleId()==3){
                    user.setUserScale("专家管理员");
                }
                if(user.getUserScaleId()==4){
                    user.setUserScale("库房管理员");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        PageInfo<UserBean>page=new PageInfo<UserBean>(list);
        session.close();
        return page;
    }

    @Override
    public List<UserBean> findAllUser() {
        SqlSession session = SqlSessionUtil.getSession();
        IUserDao iUserDao = session.getMapper(IUserDao.class);
        try {
            return iUserDao.findAllUser();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public void addUser(UserBean bean) {
        SqlSession session = SqlSessionUtil.getSession();
        IUserDao iUserDao = session.getMapper(IUserDao.class);
        try {
            iUserDao.addUser(bean);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void deleteUser(int userId) {
        SqlSession session = SqlSessionUtil.getSession();
        IUserDao iUserDao = session.getMapper(IUserDao.class);
        try {
            iUserDao.deleteUser(userId);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public void updateUser(UserBean bean) {
        SqlSession session = SqlSessionUtil.getSession();
        IUserDao iUserDao = session.getMapper(IUserDao.class);
        try {
            iUserDao.updateUser(bean);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
    }

    @Override
    public List<UserBean> findUserByuserScale(int userScaleId) {
        SqlSession session = SqlSessionUtil.getSession();
        IUserDao iUserDao = session.getMapper(IUserDao.class);
        try {

            return  iUserDao.findUserByuserScale(userScaleId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }finally {
            session.close();
        }
    }
    @Override
    public UserBean findUserById(int userId) throws Exception {
        SqlSession session = SqlSessionUtil.getSession();
        IUserDao iUserDao = session.getMapper(IUserDao.class);
        UserBean userBean = iUserDao.findUserById(userId);
        session.close();
        return userBean;
    }
}
