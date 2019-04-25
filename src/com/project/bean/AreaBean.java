package com.project.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * 区域类
 */
@Data
public class AreaBean implements Serializable {

    /**编号*/
    private Integer id;
    /**区域名称*/
    private String areaName;
    /**林种*/
    private String forestType;
    /**地类*/
    private String landType;
    /**优势树种*/
    private String dominantTree;
    /**负责小班*/
    private ClassBean chargeOfClass;


    public AreaBean() {
    }

    public AreaBean(String areaName, String forestType, String landType, String dominantTree) {
        this.areaName = areaName;
        this.forestType = forestType;
        this.landType = landType;
        this.dominantTree = dominantTree;
    }
}
