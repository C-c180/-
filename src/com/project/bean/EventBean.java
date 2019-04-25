package com.project.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 事件记录类
 */
@Data
public class EventBean implements Serializable {

    /**编号*/
    private Integer id;
    /**事件名称*/
    private String eventName;
    /**日期*/
    private String dateTimes;
    /**灾情阶段*/
    private String disasterStage;
    /**灾情描述*/
    private String disasterDesc;
    /**初步损失*/
    private double loss;
    /**防治方案*/
    private String PreventPlan;
    /**灾区图片*/
    private String imagePath;
    /**灾害类型*/
    private String disastersType;
    /**发现途径*/
    private String FoundWay;
    /**专家建议*/
    private String advice;
    /**影响面积*/
    private double AreaOfInfluence;
    /**发生位置*/
    private AreaBean happenPlace;
    /**专家会商集合*/
    private List<ExpertEventBean> list = new ArrayList<ExpertEventBean>();
}

