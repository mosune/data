package com.data.dao.impl;

import com.data.dao.FreeMealDao;
import com.data.entity.FreeMealBase;
import com.data.entity.FreeMealStatus;
import com.data.entity.SecKillBase;
import com.data.util.Page;
import com.data.util.PageParam;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 霸王餐dao的impl
 *
 * @author gcg
 * @create 2018-03-14 22:35
 **/
@Repository(value = "freeMealDao")
public class FreeMealDaoImpl extends BaseDaoImpl<FreeMealBase> implements FreeMealDao {

    @Override
    public Page<FreeMealBase> find(PageParam pageParam) {
        Page<FreeMealBase> page = new Page();
        page.setRows(getSqlSession().selectList(getSqlName("selectPage"), pageParam, new RowBounds(pageParam.getOffset(), pageParam.getPageSize())));
        Integer count = getSqlSession().selectOne(getSqlName("getCount"), pageParam);
        page.setTotal(count == null ? 0 : count);
        return page;
    }

    @Override
    public int getAwardPerCount(String id) {
        return getSqlSession().selectOne(getSqlName("getAwardPerCount"), id);
    }

    @Override
    public int getAwardCount(String id) {
        return getSqlSession().selectOne(getSqlName("getAwardCount"), id);
    }

    @Override
    public List<FreeMealStatus> getTicketStatus(String id) {
        return getSqlSession().selectList(getSqlName("getTicketStatus"), id);
    }

    @Override
    public int getTrue(String id) {
        return getSqlSession().selectOne(getSqlName("getTrue"), id);
    }

}
