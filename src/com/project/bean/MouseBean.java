package com.project.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class MouseBean implements Serializable {
    /**id*/
    private Integer id;
    /**老鼠名称*/
    private String name;
    /**食物*/
    private String food;
    /**繁殖*/
    private String breed;
    /**天敌*/
    private String enemy;
    /**防治措施*/
    private String measure;
    /**主要危害*/
    private String mainDanger;
    /**图片*/
    private String picture;
}
