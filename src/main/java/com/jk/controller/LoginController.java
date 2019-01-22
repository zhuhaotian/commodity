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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br> 
 * 〈登录〉
 *
 * @author SWORD
 * @create 2019/1/21
 * @since 1.0.0
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping("Login")
    public String LoginUserByYhMchByYhMm(User user){
        User user1 = loginService.LoginUserByYhMchByYhMm(user);
        if (user1 != null) {
            return "1";

        }
        return "0";
    }


}