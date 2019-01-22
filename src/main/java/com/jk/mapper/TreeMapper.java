package com.jk.mapper;

import com.jk.bean.Tree;

import java.util.List;

public interface TreeMapper {
    List<Tree> findAll(Tree vo);

}
