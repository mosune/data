package com.data.service.impl;

import com.data.dao.WheelDao;
import com.data.entity.WheelBase;
import com.data.service.WheelService;
import com.data.util.Page;
import com.data.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 大转盘活动接口impl
 *
 * @author gcg
 */
@Service(value = "wheelService")
public class WheelServiceImpl implements WheelService {

    @Autowired
    private WheelDao wheelDao;

    @Override
    public Page<WheelBase> find(PageParam pageParam) {
        return wheelDao.find(pageParam);
    }

    @Override
    public int getLotteryCount(String id, List<String> list) {
        return wheelDao.getLotteryCount(id, list);
    }

    @Override
    public int getJoinCount(String id) {
        return wheelDao.getJoinCount(id);
    }

    @Override
    public int getJoinNum(String id) {
        return wheelDao.getJoinNum(id);
    }

    @Override
    public int getTicketUsedCase(String id) {
        return wheelDao.getTicketUsedCase(id);
    }

    @Override
    public int getTicketPastCase(String id) {
        return wheelDao.getTicketPastCase(id);
    }

}
