package com.jk.service;

import com.jk.bean.Attribute;
import com.jk.bean.MallAttr;
import com.jk.utils.QueryParam;
import com.jk.utils.ResultPage;

public interface PropertyService {

    //查询属性值表
    ResultPage queryListAttribute(Integer rows, Integer page, Attribute attribute);

    //新增属性
    void addAttr(MallAttr arr, QueryParam param);

}
