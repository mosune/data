package com.data.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 秒杀活动配置基础
 *
 * @author gcg
 */
@Data
public class SecKillBase implements Serializable {

    // 秒杀配置id
    private String id;

    // 门店id
    private int shopId;

    // 门店名称
    private String shopName;

    // 转盘活动名称
    private String secKillName;

    // 商家类型
    private String isChain;

    // 活动开始时间
    private Date startTime;

    // 活动结束时间
    private Date endTime;

    // 活动状态
    private String status;

    // 所属行业
    private String cate;

    // 商品总数
    private int shopCount;

    // 已购买商品总数
    private int buyShopCount;

    // 创建时间
    private Date createTime;

}
