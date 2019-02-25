/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: robot
 * Author:   SWORD
 * Date:     2019/2/25 10:29
 * Description: 机器人
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.jk.utils.HttpClientUtil;
import com.jk.utils.JsonUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;

/**
 * 〈一句话功能简述〉<br> 
 * 〈机器人〉
 *
 * @author SWORD
 * @create 2019/2/25
 * @since 1.0.0
 */
@Controller
@RequestMapping("robot")
public class robot {

    @RequestMapping("toRobotPage")
    public String toRobotPage(){
        return "talktorobot";
    }

    @RequestMapping("talkToRobot")
    @ResponseBody
    public HashMap<String, Object> talkToRobot(String text) throws IOException {
        HashMap<String, Object> resultmap = new HashMap<String, Object>();
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("msg",text);
        String string = HttpClientUtil.get("http://api.qingyunke.com/api.php?key=free&appid=0&", params);

        JsonNode jsonToJsonNode = JsonUtil.jsonToJsonNode(string);
        resultmap.put("content", jsonToJsonNode.get("content").toString());
        return resultmap;
    }

}