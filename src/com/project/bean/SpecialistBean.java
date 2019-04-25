package com.project.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class SpecialistBean implements Serializable {
    /**专家编号*/
    private Integer specialistId;
    /**专家姓名*/
    private String specialistName;
    /**工作单位*/
    private String workunit;
    /**专长*/
    private String speciality;
    /**职务*/
    private String duty;
    /**电话*/
    private String telphone;
    /**出生年月*/
    private String birthday;
    /**性别*/
    private String sex;
    /**通讯地址*/
    private String address;
    /**邮箱*/
    private String email;
    /**图片*/
    private String picture;

}
