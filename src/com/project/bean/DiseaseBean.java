package com.project.bean;

import lombok.Data;

import java.io.Serializable;
@Data
public class DiseaseBean implements Serializable {
    /**id*/
    private Integer id;
    /**病害名称*/
    private String name;
    /**病原*/
    private String pathogeny;
    /**症状*/
    private String symptom;
    /**发病规律*/
    private String rule;
    /**主要危害*/
    private String mainDanger;
    /**防治措施*/
    private String measure;
    /**图片*/
    private String picture;
}
