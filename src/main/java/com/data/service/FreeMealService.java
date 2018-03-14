package com.data.service;

import com.data.entity.FreeMealBase;
import com.data.util.Page;
import com.data.util.PageParam;

/**
 * 霸王餐配置service
 *
 * @author gcg
 */
public interface FreeMealService {

    /**
     * 霸王餐列表
     * @param pageParam
     * @return
     */
    Page<FreeMealBase> find(PageParam pageParam);

}
