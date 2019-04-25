package com.project.service;
import com.github.pagehelper.PageInfo;
import com.project.bean.LogBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ILogService {
    /**
     * 查询所有的日志
     * @return 日志对象集合
     */
  public List<LogBean> findAllLog();

    /**
     * 动态条件分页查询日志信息
     * @param condition 条件map集合
     * @return 分页对象
     */
    public PageInfo<LogBean> findByCondition(Map<String, String> condition);
    /**
     * 通过开始日期和结束日期查询日志
     * @param startDate 开始日期
     * @param endDate 结束日期
     * @return 日志对象集合
     */
  public List<LogBean> findLogByStartDateAndEndDate(String startDate, String endDate);

  /**
   * 添加日志
   * @param bean 日志对象
   * @throws Exception
   */
  public void addLog(LogBean bean) throws Exception;
}
