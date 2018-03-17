package com.data.service;

import com.data.entity.WheelBase;
import com.data.util.Page;
import com.data.util.PageParam;

import java.util.List;

/**
 * 大转盘Service接口
 *
 * @author gcg
 */
public interface WheelService {

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
     * 参与活动人数
     * @param id
     * @return
     */
    int getJoinCount(String id);

    /**
     * 参与活动次数
     * @param id
     * @return
     */
    int getJoinNum(String id);

    /**
     * 已使用券
     * @param id
     * @return
     */
    int getTicketUsedCase(String id);

    /**
     * 已过期券
     * @param id
     * @return
     */
    int getTicketPastCase(String id);
}
