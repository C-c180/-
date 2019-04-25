package com.project.bean;

import lombok.Data;

@Data
public class CountOutboundBean {
    /**出库类型*/
    private String outboundType;
    /**出库id*/
    private int outboundTypeId;
    /**出库总数量*/
    private int outboundNum;
}
