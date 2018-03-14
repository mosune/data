package com.data.dao;

import com.data.entity.SecKillBase;
import com.data.entity.SecKillStatus;
import com.data.util.Page;
import com.data.util.PageParam;

import java.util.List;

/**
 * 秒杀实现dao
 *
 * @author gcg
 */
public interface SecKillDao {

    /**
     * 秒杀列表
     * @param pageParam
     * @return
     */
    Page<SecKillBase> find(PageParam pageParam);

    /**
     * 获取订单状态列表
     * @param id
     * @return
     */
    List<SecKillStatus> getOrderStatus(String id);

    /**
     * 获取下单数量
     * @param id
     * @return
     */
    int getOrderCount(String id);

    /**
     * 获取商品数量
     * @param id
     * @return
     */
    int getShopCount(String id);
}
