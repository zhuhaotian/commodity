/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: LoginServiceImpl
 * Author:   SWORD
 * Date:     2019/1/21 15:00
 * Description: denglu
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.mapper.LoginMapper;
import com.jk.bean.User;
import com.jk.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 〈一句话功能简述〉<br> 
 * 〈denglu〉
 *
 * @author SWORD
 * @create 2019/1/21
 * @since 1.0.0
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User LoginUserByYhMchByYhMm(User user) {
        return loginMapper.LoginUserByYhMchByYhMm(user);

    }
}