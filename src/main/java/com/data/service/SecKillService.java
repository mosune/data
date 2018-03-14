package com.data.service;

import com.data.entity.SecKillBase;
import com.data.entity.SecKillStatus;
import com.data.util.Page;
import com.data.util.PageParam;

import java.util.List;

/**
 * 秒杀Service接口
 *
 * @author gcg
 */
public interface SecKillService {

    /**
     * 获取列表
     * @param pageParam
     * @return
     */
    Page<SecKillBase> find(PageParam pageParam);

    /**
     * 获取订单状态
     * @param id
     * @return
     */
    List<SecKillStatus> getOrderStatus(String id);

    /**
     * 获取商品下单数量
     * @param id
     * @return
     */
    int getOrderCount(String id);

    /**
     * 获取商品总数
     * @param id
     * @return
     */
    int getShopCount(String id);

}
