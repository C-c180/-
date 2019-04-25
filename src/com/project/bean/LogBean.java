package com.project.bean;

import lombok.Data;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class LogBean implements Serializable {
    private int id;
    private String logContent ;
    private String logDate;
    public LogBean() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat ft =new SimpleDateFormat("yyyy-MM-dd");
        this.logDate = ft.format(date);
    }
}
