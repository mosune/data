package com.data.service.impl;

import com.data.dao.FreeMealDao;
import com.data.entity.FreeMealBase;
import com.data.service.FreeMealService;
import com.data.util.Page;
import com.data.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 霸王餐service的impl
 *
 * @author gcg
 * @create 2018-03-14 22:19
 **/
@Service(value = "freeMealService")
public class FreeMealServiceImpl implements FreeMealService {

    @Autowired
    private FreeMealDao freeMealDao;

    @Override
    public Page<FreeMealBase> find(PageParam pageParam) {
        return freeMealDao.find(pageParam);
    }

}
