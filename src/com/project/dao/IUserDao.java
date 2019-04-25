package com.project.dao;

import com.project.bean.UserBean;
import com.project.getSql.UserSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface IUserDao {


@Select("select id,userName,pwd,realName,userScaleId from t_user where userName=#{username} and pwd=#{pwd}")
    public UserBean login(@Param("username") String userName,@Param("pwd") String pwd) throws Exception;


    @Select("select id,userName,pwd,realName,userScaleId from t_user")
    public List<UserBean> findAllUser()throws Exception;


    @Insert("insert into t_user(userName,pwd,realName,userScaleId)values(#{userName},#{pwd},#{realName},#{userScaleId})")
    public  void addUser(UserBean bean)throws Exception;


    @Delete("delete from t_user where id=#{userid}")
    public void deleteUser(@Param("userid") int userId)throws Exception;

    @Update("update t_user set pwd=#{pwd},userScaleId=#{userScaleId} where id=#{id}")
    public void updateUser(UserBean bean) throws Exception;


    @Select("select id,userName,pwd,realName,userScaleId from t_user where userScaleId=#{userScaleId}")
    public List<UserBean> findUserByuserScale(@Param("userScaleId") int userScaleId)throws Exception;

    @SelectProvider(type=UserSqlProvider.class,method="getUserByCondition")
    @ResultMap(value="com.project.dao.IUserDao.map.userMap")
    public List<UserBean> findUserCondition(Map<String,String> condition) throws Exception;
    @Select("select userName,pwd,realName,userScaleId from t_user where id=#{userid}")
    public UserBean findUserById( @Param("userid") int userId) throws Exception;
}
