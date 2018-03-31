package com.data.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 霸王餐
 *
 * @author gcg
 * @create 2018-03-14 22:05
 **/
@Data
public class FreeMealBase implements Serializable {

    // 霸王餐配置id
    private String id;

    // 商店id
    private int shopId;

    // 商店名称
    private String shopName;

    // 商家类型
    private String isChain;

    // 霸王餐配置名称
    private String freeMealName;

    // 活动开始时间
    private Date startTime;

    // 活动结束时间
    private Date endTime;

    // 奖励时间
    private Date awardTime;

    // 状态
    private String status;

    // 所属行业
    private String cate;

    // 报名人数
    private int realJoinNo;

    // 中奖名额
    private int awardNo;

    // 中奖人数
    private int getAwardNo;

    // 创建时间
    private Date createTime;

    // 奖品数
    // private int awardShopNo;

}
