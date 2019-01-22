/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: TreeServiceImpl
 * Author:   SWORD
 * Date:     2019/1/21 16:10
 * Description: 左侧树
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.jk.service.impl;

import com.jk.bean.Tree;
import com.jk.mapper.TreeMapper;
import com.jk.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈左侧树〉
 *
 * @author SWORD
 * @create 2019/1/21
 * @since 1.0.0
 */
@Service
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeMapper treeMapper;

    @Override
    public List<Tree> list(Tree vo) {
        List<Tree> list = treeMapper.findAll(vo);
        for(Tree tree : list) {
            if("0".equals(tree.getPid())) {
                tree.setState("closed");
            }
            tree.setPid(tree.getId());
            tree.setChildren(this.list(tree));
        }
        return list;
    }
}