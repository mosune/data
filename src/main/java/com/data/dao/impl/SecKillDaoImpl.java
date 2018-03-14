package com.data.dao.impl;

import com.data.dao.SecKillDao;
import com.data.entity.SecKillBase;
import com.data.entity.SecKillStatus;
import com.data.util.Page;
import com.data.util.PageParam;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 秒杀配置实现dao
 *
 * @author gcg
 */
@Repository(value = "secKillDao")
public class SecKillDaoImpl extends BaseDaoImpl<SecKillBase> implements SecKillDao {

    @Override
    public Page<SecKillBase> find(PageParam pageParam) {
        Page<SecKillBase> page = new Page();
        page.setRows(getSqlSession().selectList(getSqlName("selectPage"), pageParam, new RowBounds(pageParam.getOffset(), pageParam.getPageSize())));
        Integer count = getSqlSession().selectOne(getSqlName("getCount"), pageParam);
        page.setTotal(count == null ? 0 : count);
        return page;
    }

    @Override
    public List<SecKillStatus> getOrderStatus(String id) {
        return getSqlSession().selectList(getSqlName("getOrderStatus"), id);
    }

    @Override
    public int getOrderCount(String id) {
        return getSqlSession().selectOne(getSqlName("getOrderCount"), id);
    }

    @Override
    public int getShopCount(String id) {
        return getSqlSession().selectOne(getSqlName("getShopCount"), id);
    }

}
