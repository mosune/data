package com.data.service.impl;

import com.data.dao.FreeMealDao;
import com.data.entity.FreeMealBase;
import com.data.entity.FreeMealStatus;
import com.data.service.FreeMealService;
import com.data.util.Page;
import com.data.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public int getAwardPerCount(String id) {
        return freeMealDao.getAwardPerCount(id);
    }

    @Override
    public int getAwardCount(String id) {
        return freeMealDao.getAwardCount(id);
    }

    @Override
    public List<FreeMealStatus> getTicketStatus(String id) {
        return freeMealDao.getTicketStatus(id);
    }

    @Override
    public int getTrue(String id) {
        return freeMealDao.getTrue(id);
    }
}
