package com.data.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 秒杀下单状态
 *
 * @author gcg
 */
@Data
public class SecKillStatus implements Serializable {

    // 下单状态
    private String orderStatus;

    // 各种状态的总数
    private int count;

}
