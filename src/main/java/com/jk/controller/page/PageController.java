/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PageController
 * Author:   SWORD
 * Date:     2019/1/21 14:45
 * Description: 跳转页面
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 〈一句话功能简述〉<br> 
 * 〈跳转页面〉
 *
 * @author SWORD
 * @create 2019/1/21
 * @since 1.0.0
 */
@Controller
public class PageController {

    @RequestMapping("tologin")
    String tologin(){
        return "login";
    }

    @RequestMapping("queryUserListHtml")
    public String toshow(){
        return "show";
    }


}