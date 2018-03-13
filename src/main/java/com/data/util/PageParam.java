package com.data.util;

import lombok.Data;

import java.io.Serializable;

/**
 * 分页参数
 * @author gcg
 * 
 * 2017年4月14日 下午4:15:04
 */
@Data
public class PageParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1734516368014351348L;

	private int pageNo; // 当前页码
	private int pageSize; // 页大小
	private int offset; //分页记录偏移量
	
	public PageParam() {
	}

	public PageParam(int offset, int pageSize) {
		this.pageSize = pageSize;
		this.offset = offset;
		this.pageNo = offset / pageSize + 1;
	}

}
