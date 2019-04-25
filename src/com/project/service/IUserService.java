package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.UserBean;
import java.util.List;
import java.util.Map;

public interface IUserService {
    /**
     * 通过用户名和密码登录
     * @param userName 用户名
     * @param pwd 密码
     * @return 用户对象
     */
  public UserBean login(String userName, String pwd) throws Exception;

    /**
     * 动态条件分页查询用户信息
     * @param condition 条件map集合
     * @return 分页对象
     */
    public PageInfo<UserBean> findByCondition(Map<String, String> condition) throws Exception;
    /**
     * 查询所有的用户
     * @return 用户对象集合
     */
  public List<UserBean> findAllUser() throws Exception;

    /**
     * 添加用户
     * @param bean 用户对象
     */
  public  void addUser(UserBean bean) throws Exception;

    /**
     * 删除用户
     * @param userId 用户id
     */
   public void deleteUser(int userId) throws Exception;

    /**
     * 修改用户
     * @param bean 用户对象
     */
   public void updateUser(UserBean bean) throws Exception;

    /**
     * 通过等级查询用户
     * @param userScaleId 用户等级
     * @return 用户对象集合
     */
   public List<UserBean> findUserByuserScale(int userScaleId) throws Exception;

    /**
     * 根据用户ID查找用户
     * @param userId 用户ID
     * @return 用户对象
     * @throws Exception
     */
    public UserBean findUserById(int userId) throws Exception;
}
