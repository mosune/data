package com.data.controller;

import com.alibaba.fastjson.JSONObject;
import com.data.entity.WheelBase;
import com.data.service.WheelService;
import com.data.util.Page;
import com.data.util.PageParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 大转盘controller
 *
 * @author gcg
 */
@RestController
@RequestMapping(value = "wheel")
public class WheelController {

    @Autowired
    private WheelService wheelService;

    /**
     * 获取列表数据
     * @param limit
     * @param offset
     * @return
     */
    @RequestMapping("list.do")
    public JSONObject list(int limit, int offset) {
        JSONObject result = new JSONObject();
        PageParam pageParam = new PageParam(offset, limit);
        Page<WheelBase> page = wheelService.find(pageParam);
        result.put("total", page.getTotal());
        result.put("rows", page.getRows());
        return result;
    }

    /**
     * 获取单个记录的数据
     * @param id
     * @return
     */
    @RequestMapping("getData.do")
    public JSONObject getData(String id) {
        JSONObject result = new JSONObject();
        List<String> types = new ArrayList<>(2);
        result.put("getJoinCount", wheelService.getJoinCount(id)); // 参与活动人数
        result.put("getJoinNum", wheelService.getJoinNum(id)); // 参与活动次数
        result.put("getLottery" , wheelService.getLotteryCount(id, getList(types, "COUPON", "CREDIT"))); // 中奖次数
        result.put("notGetLottery" , wheelService.getLotteryCount(id, getList(types, "NONE"))); // 未中奖次数
        result.put("integralLottery" , wheelService.getLotteryCount(id, getList(types, "CREDIT"))); // 积分中奖次数
        result.put("ticketLottery" , wheelService.getLotteryCount(id, getList(types, "COUPON"))); // 券中奖次数
        result.put("ticketUsed" , wheelService.getTicketCase(id, getList(types, "LOCKED", "PICKED"))); // 已使用券
        result.put("ticketPast" , wheelService.getTicketCase(id, getList(types, "EXPIRED"))); // 已过期券
        return result;
    }

    /**
     * 添加数据
     * @param list
     * @param objs
     * @return
     */
    private List<String> getList(List<String> list, String...objs) {
        list.clear();
        for (String s : objs) {
            list.add(s);
        }
        return list;
    }

}
