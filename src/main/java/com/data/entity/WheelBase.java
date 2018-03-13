package com.data.entity;

import lombok.Data;

import java.util.Date;

/**
 * 大转盘基础数据
 * @author gcg
 *
 */
@Data
public class WheelBase {

    // 大转盘配置id
    private String id;

    // 门店id
    private int shopId;

    // 门店名称
    private String name;

    // 商家类型
    private String isChain;

    // 转盘活动名称
    private String title;

    // 活动开始时间
    private Date startDate;

    // 活动结束时间
    private Date endDate;

    // 转盘类型
    private String entryType;

    // 活动状态
    private String status;

    // 所属行业
    private String cate;

}
