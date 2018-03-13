package com.data.dao;

import com.data.entity.WheelBase;
import com.data.util.Page;
import com.data.util.PageParam;

import java.util.List;

/**
 * 大转盘活动的dao
 *
 * @author gcg
 */
public interface WheelDao {

    /**
     * 查询列表
     * @param pageParam
     * @return
     */
    Page<WheelBase> find(PageParam pageParam);

    /**
     * 查询中奖次数
     * @param id
     * @param list
     * @return
     */
    int getLotteryCount(String id, List<String> list);

    /**
     * 查询券情况
     * @param id
     * @param list
     * @return
     */
    int getTicketCase(String id, List<String> list);

    /**
     * 查询活动参与人数
     * @param id
     * @return
     */
    int getJoinCount(String id);

    /**
     * 查询参与活动次数
     * @param id
     * @return
     */
    int getJoinNum(String id);
}
