package com.data.service.impl;

import com.data.dao.SecKillDao;
import com.data.entity.SecKillBase;
import com.data.entity.SecKillStatus;
import com.data.service.SecKillService;
import com.data.util.Page;
import com.data.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 秒杀service实现
 *
 * @author gcg
 */
@Service(value = "secKillService")
public class SecKillServiceImpl implements SecKillService {

    @Autowired
    private SecKillDao secKillDao;

    @Override
    public Page<SecKillBase> find(PageParam pageParam) {
        return secKillDao.find(pageParam);
    }

    @Override
    public List<SecKillStatus> getOrderStatus(String id) {
        return secKillDao.getOrderStatus(id);
    }

    @Override
    public int getOrderCount(String id) {
        return secKillDao.getOrderCount(id);
    }

    @Override
    public int getShopCount(String id) {
        return secKillDao.getShopCount(id);
    }

}
