package com.jk.service.impl;
import com.github.pagehelper.PageHelper;
import com.jk.bean.Attribute;
import com.jk.bean.MallAttr;
import com.jk.mapper.PropertyMapper;
import com.jk.service.PropertyService;
import com.jk.utils.PageUtil;
import com.jk.utils.QueryParam;
import com.jk.utils.ResultPage;
import com.jk.utils.ReturnPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Resource
    PropertyMapper mapper;

    //查询属性值
    @Override
    public ReturnPage queryListAttribute(Integer rows, Integer page, Attribute attribute) {

        List list=mapper.queryListAttribute(attribute);

        PageHelper.startPage(page,rows);
        List listData=mapper.queryListAttribute(attribute);
        ReturnPage returnPage=new ReturnPage(list.size(),listData);
        return returnPage;
    }

    //新增属性
    public void addAttr(MallAttr arr, QueryParam param) {
        ArrayList<Attribute> attribute = param.getAttribute();
        Integer shxm_id=null;

            shxm_id=mapper.getArrrId(arr.getShxm_mch());
            if(shxm_id==null){
                mapper.addMallAttr(arr);
                shxm_id=arr.getTempid();
                System.out.println(shxm_id);
            }
        for (Attribute attribute1 : attribute) {
            attribute1.setShxm_id(shxm_id);
        }
        mapper.addAttr(attribute);
    }
}
