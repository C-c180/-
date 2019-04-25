package com.project.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserBean implements Serializable {
   private Integer id;
   private String userName;
   private String pwd;
   private String realName;
   private String userScale;
   private int userScaleId;
}
