package com.project.service;


import com.github.pagehelper.PageInfo;
import com.project.bean.EventBean;
import com.project.bean.ExpertEventBean;

import java.util.Map;

public interface IExpertEventService {
    /**
     * 会商信息
     * @param eventId 事件Id
     * @return 事件对象
     * @throws Exception
     */
     public EventBean searchExpertInfo(Integer eventId)throws Exception;

    /**
     * 添加会商信息
     * @param expertEventBean 专家会商对象
     * @throws Exception
     */
     public void addExpertInformation(ExpertEventBean expertEventBean)throws Exception;

    /**
     * 查询所有事件
     * @return 返回分页对象
     */
     public PageInfo<EventBean> findAllExperteventBean(Map<String, String> stringStringMap);


}
