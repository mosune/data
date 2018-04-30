package com.data.service;

import com.data.entity.FreeMealBase;
import com.data.entity.FreeMealStatus;
import com.data.util.Page;
import com.data.util.PageParam;

import java.util.List;

/**
 * 霸王餐配置service
 *
 * @author gcg
 */
public interface FreeMealService {

    /**
     * 霸王餐列表
     * @param pageParam
     * @return
     */
    Page<FreeMealBase> find(PageParam pageParam);

    /**
     * 获取中奖人数
     * @param id
     * @return
     */
    int getAwardPerCount(String id);

    /**
     * 获取中奖商品数
     * @param id
     * @return
     */
    int getAwardCount(String id);

    /**
     * 获取券状态和数量
     * @param id
     * @return
     */
    List<FreeMealStatus> getTicketStatus(String id);

    int getTrue(String id);

}
