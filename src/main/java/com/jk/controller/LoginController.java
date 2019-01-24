/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LoginController
 * Author:   SWORD
 * Date:     2019/1/21 14:59
 * Description: 登录
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.bean.User;
import com.jk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 〈一句话功能简述〉<br> 
 * 〈登录〉
 *
 * @author SWORD
 * @create 2019/1/21
 * @since 1.0.0
 */
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     *    验证用户名  密码是否一致
     */
    @RequestMapping("Login")
    @ResponseBody
    public String LoginUserByYhMchByYhMm(User user){
        User user1 = loginService.LoginUserByYhMchByYhMm(user);
        if (user1 != null) {
            return "1";

        }
        return "0";
    }

    @RequestMapping("queryloginuser")
    @ResponseBody
    public User queryloginuser(@RequestBody User user){
        User user1 = loginService.LoginUserByYhMchByYhMm(user);
        return user1;
    }

}