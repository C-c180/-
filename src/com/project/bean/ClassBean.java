package com.project.bean;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 小班管理类
 */
@Data
public class ClassBean implements Serializable {

    /**编号*/
    private Integer id;
    /**小班名称*/
    private String clazzName;
    /**人数*/
    private int personNum;
    /**负责人*/
    private String principal;
    /**创建时间*/
    String creatDate ;
    /**负责人电话*/
    private String principalTel;
    /**负责区域*/
    private AreaBean chargeOfArea;

    public ClassBean() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat ft =new SimpleDateFormat("yyyy-MM-dd");
        this.creatDate = ft.format(date);
    }

    public ClassBean(String clazzName, int personNum, String principal, String principalTel, AreaBean chargeOfArea) {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat ft =new SimpleDateFormat("yyyy-MM-dd");
        this.creatDate = ft.format(date);
        this.clazzName = clazzName;
        this.personNum = personNum;
        this.principal = principal;
        this.principalTel = principalTel;
        this.chargeOfArea = chargeOfArea;
    }
}
