package com.project.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class MechanicalManagementBean<T> implements Serializable {
    /**机械Id*/
    private Integer mechanicalId;
    /**机械名字*/
    private String mechanicalName;
    /**防治类型Id*/
    private int preventCureTypeId;
    /**防治类型*/
    private String preventCureName;
    /**主要用途*/
    private String mainUse;
}