package com.data.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 大转盘基础数据
 * @author gcg
 *
 */
@Data
public class WheelBase implements Serializable {

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

    // 参与人数
    private int joinCount;

    // 参与次数
    private int joinNum;

    // 已中奖
    private int getLottery;

    // 未中奖
    private int notGetLottery;

    // 积分中奖
    private int integralLottery;

    // 券中奖
    private int ticketLottery;

    // 已使用券
    private int ticketUsed;

    // 已过期券
    private int ticketPast;

    // 创建时间
    private Date createTime;

}
