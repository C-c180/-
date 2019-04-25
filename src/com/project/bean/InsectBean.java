package com.project.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class InsectBean implements Serializable {
    private Integer id;
    /**虫害名称*/
    private String name;
    /**寄主名称*/
    private String hostName;
    /**繁殖*/
    private String breed;
    /**天敌*/
    private String enemy;
    /**控制措施*/
    private String controlling;
    /**主要危害*/
    private String danger;
    /**幼虫图片*/
    private String childPicture;
    /**成虫图片*/
    private String insectPicture;
}
