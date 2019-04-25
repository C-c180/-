package com.project.service;

import com.github.pagehelper.PageInfo;
import com.project.bean.EventBean;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * 事件记录业务接口
 */
public interface IEventService {

    /**
     * 动态条件分页查询信息
     * @param condition 动态条件map集合
     * @return 分页对象
     */
    public PageInfo<EventBean> findEventByCondition(Map<String, String> condition);

    /**
     * 根据事件id查看事件信息
     * @param eventId 事件id
     * @return 事件对象
     */
    public EventBean showEventInfo(int eventId);

    /**
     * 申请专家会审,修改灾情状态为“无法解决，申请专家会商”
     * @param eventBean 事件对象
     */
    public void applyCheck(EventBean eventBean);

    /**
     * 修改事件的信息
     * @param eventBean 事件对象
     */
    public int updateEventInfo(EventBean eventBean);

    /**
     * 添加事件信息
     * @param eventBean 事件对象
     */
    public int addEvent(EventBean eventBean);

    /**
     * 删除事件
     * @param id 事件id
     */
    public int deleteEvent(int id);
}
