package com.data.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 券状态和数量
 *
 * @author gcg
 */
@Data
public class FreeMealStatus implements Serializable {

    // 券状态
    private String status;

    // 券数量
    private int count;

}
