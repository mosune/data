package com.data.controller;

import com.alibaba.fastjson.JSONObject;
import com.data.entity.SecKillBase;
import com.data.entity.SecKillStatus;
import com.data.service.SecKillService;
import com.data.util.Page;
import com.data.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 秒杀
 *
 * @author gcg
 */
@RestController
@RequestMapping(value = "secKill")
public class SecKillController {

    @Autowired
    private SecKillService secKillService;

    /**
     * 秒杀列表
     * @param limit
     * @param offset
     * @return
     */
    @RequestMapping("list.do")
    public JSONObject list(int limit, int offset) {
        JSONObject result = new JSONObject();
        PageParam pageParam = new PageParam(offset, limit);
        Page<SecKillBase> page = secKillService.find(pageParam);
        result.put("total", page.getTotal());
        for (Object o : page.getRows()) {
            SecKillBase secKillBase = (SecKillBase) o;
            secKillBase.setShopCount(secKillService.getShopCount(secKillBase.getId()));
            secKillBase.setBuyShopCount(secKillService.getOrderCount(secKillBase.getId()));
        }
        result.put("rows", page.getRows());
        return result;
    }

    /**
     * 获取状态及数量
     * @param id
     * @return
     */
    @RequestMapping("getStatus.do")
    public JSONObject getStatus(String id) {
        JSONObject result = new JSONObject();
        List<SecKillStatus> list = secKillService.getOrderStatus(id);
        result.put("rows", list);
        return  result;
    }

}
