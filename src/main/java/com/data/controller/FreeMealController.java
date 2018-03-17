package com.data.controller;

import com.alibaba.fastjson.JSONObject;
import com.data.entity.FreeMealBase;
import com.data.entity.FreeMealStatus;
import com.data.service.FreeMealService;
import com.data.util.Page;
import com.data.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 霸王餐
 *
 * @author gcg
 */
@RestController
@RequestMapping(value = "freeMeal")
public class FreeMealController {

    @Autowired
    private FreeMealService freeMealService;

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
        Page<FreeMealBase> page = freeMealService.find(pageParam);
        result.put("total", page.getTotal());
        for (Object o : page.getRows()) {
            FreeMealBase freeMealBase = (FreeMealBase) o;
            freeMealBase.setGetAwardNo(freeMealService.getAwardPerCount(freeMealBase.getId())); // 中奖人数
            // freeMealBase.setAwardShopNo(freeMealService.getAwardCount(freeMealBase.getId())); // 奖品数
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
        List<FreeMealStatus> list = freeMealService.getTicketStatus(id);
        result.put("rows", list);
        return  result;
    }

}
