package com.project.bean;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
public class ExpertEventBean implements Serializable {
    /**事件编号*/
    private Integer eventId;
    /**会商结果*/
    private String result;
    /**日期*/
    private String dataTime;
    /**会商人员*/
    private String staff;
    /**事件对象*/
    private EventBean eventBean;

    public ExpertEventBean() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat ft =new SimpleDateFormat("yyyy-MM-dd");
        this.dataTime = ft.format(date);
    }

}
