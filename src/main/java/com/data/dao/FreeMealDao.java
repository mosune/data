package com.data.dao;

import com.data.entity.FreeMealBase;
import com.data.entity.FreeMealStatus;
import com.data.util.Page;
import com.data.util.PageParam;

import java.util.List;

/**
 * 霸王餐基础dao
 *
 * @author gcg
 * @create 2018-03-14 22:20
 **/
public interface FreeMealDao {

    /**
     * 查询列表
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
     * 获取中奖产品数
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
