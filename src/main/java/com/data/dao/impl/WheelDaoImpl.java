package com.data.dao.impl;

import com.data.dao.WheelDao;
import com.data.entity.WheelBase;
import com.data.util.Page;
import com.data.util.PageParam;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 大转盘活动dao的impl
 *
 * @author gcg
 */
@Repository(value = "wheelDao")
public class WheelDaoImpl extends BaseDaoImpl<WheelBase> implements WheelDao {

    @Override
    public Page<WheelBase> find(PageParam pageParam) {
        Page<WheelBase> page = new Page();
        page.setRows(getSqlSession().selectList(getSqlName("selectPage"), pageParam, new RowBounds(pageParam.getOffset(), pageParam.getPageSize())));
        Integer count = getSqlSession().selectOne(getSqlName("getCount"), pageParam);
        page.setTotal(count == null ? 0 : count);
        return page;
    }

    @Override
    public int getLotteryCount(String id, List<String> list) {
        Map<String, Object> map = new HashMap<>();
        map.put("id", id);
        map.put("list", list);
        return getSqlSession().selectOne(getSqlName("getLotteryCount"), map);
    }

    @Override
    public int getJoinCount(String id) {
        return getSqlSession().selectOne(getSqlName("getJoinCount"), id);
    }

    @Override
    public int getJoinNum(String id) {
        return getSqlSession().selectOne(getSqlName("getJoinNum"), id);
    }

    @Override
    public int getTicketUsedCase(String id) {
        return getSqlSession().selectOne(getSqlName("getTicketUsedCase"), id);
    }

    @Override
    public int getTicketPastCase(String id) {
        return getSqlSession().selectOne(getSqlName("getTicketPastCase"), id);
    }

}
