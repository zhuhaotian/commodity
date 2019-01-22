package com.jk.service.impl;
import com.jk.bean.Attribute;
import com.jk.bean.MallAttr;
import com.jk.mapper.PropertyMapper;
import com.jk.service.PropertyService;
import com.jk.utils.PageUtil;
import com.jk.utils.QueryParam;
import com.jk.utils.ResultPage;
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
    public ResultPage queryListAttribute(Integer rows, Integer page, Attribute attribute) {
        ResultPage resultPage = new ResultPage();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("Attribute", attribute);
        int count = mapper.queryListToTalCount(hashMap);
        PageUtil<Attribute> pageUtil = new PageUtil<>(count, page, rows);
        hashMap.put("start", pageUtil.getStartIndex());
        hashMap.put("end", pageUtil.getEndIndex());
        List<Attribute> attribute1 = mapper.queryListAttribute(hashMap);
        resultPage.setRows(attribute1);
        resultPage.setTotal(count);
        return resultPage;
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
