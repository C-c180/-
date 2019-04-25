package com.project.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class PotionManagementBean<T> implements Serializable {
    /**药剂id*/
    private Integer potionId;
    /**药剂名字*/
    private String potionName;
    /**防治类型 Id*/
    private int preventCureTypeId;
    /**防治类型*/
    private String preventCureType;
    /**适合树种*/
    private String treeSpecies;
    /**泛型list*/
    private List<T> list;
//    /**病虫害 Id*/
//    private int DiseasesAndPestsId;
    /**病虫害名称*/
    private String diseasesAndPestsName;
}