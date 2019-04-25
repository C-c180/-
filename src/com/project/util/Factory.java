package com.project.util;

import java.util.Properties;

public class Factory {
    private static Properties properties=new Properties();
    //static {
    //    try {
    //        properties.load(new FileInputStream(new File("interface.properites")));
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //}
    //public static Object getBean(String interfaceName){
    //    Object object=null;
    //    String classpath = properties.getProperty(interfaceName);
    //    try {
    //        Class<?> c = Class.forName(classpath);
    //        object=c.newInstance();
    //    } catch (Exception e) {
    //        e.printStackTrace();
    //    }
    //    return object;
    //}
    //public static void main(String[] args){
    //    System.out.println(Factory.getBean("IMouseService"));
    //}
}
