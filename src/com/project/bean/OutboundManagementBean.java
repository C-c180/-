package com.project.bean;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
@Data
public class OutboundManagementBean implements Serializable {
    /**出库Id*/
    private Integer outboundId;
    /**出库时间*/
    private Date outboundDate=new Date(System.currentTimeMillis());
    /**出库类型 id*/
    private int outboundTypeId;
    /**防治类型 id*/
    private int preventCureTypeId;
//    /**物品名称 id*/
//    private int itemNameId;
    /**物品名称*/
    private String itemName;
    /**领取数量*/
    private int recipientsNum;
    /**主要用途*/
    private String mainUse;
    /**班级id*/
    private int classId;
    /**班级名字*/
    private String className;
}