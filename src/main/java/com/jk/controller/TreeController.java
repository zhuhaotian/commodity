/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TreeController
 * Author:   SWORD
 * Date:     2019/1/21 16:09
 * Description: 左侧树
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.controller;

import com.jk.bean.Tree;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈左侧树〉
 *
 * @author SWORD
 * @create 2019/1/21
 * @since 1.0.0
 */
@RestController
public class TreeController {

    @Autowired
    private TreeService treeService;

    @RequestMapping("queryTree")
    public List<Tree> list(Tree vo){
        vo.setPid(vo.getId());
        return treeService.list(vo);
    }
}