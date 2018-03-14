package com.data.dao;

import com.data.entity.FreeMealBase;
import com.data.util.Page;
import com.data.util.PageParam;

/**
 * 霸王餐基础dao
 *
 * @author gcg
 * @create 2018-03-14 22:20
 **/
public interface FreeMealDao {

    /**
     * 查询列表
     * @param pageParam
     * @return
     */
    Page<FreeMealBase> find(PageParam pageParam);

}
