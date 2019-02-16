package com.jk.service.impl;

import com.jk.bean.CopySku;
import com.jk.mapper.EchartsMapper;
import com.jk.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EchartsServiceImpl implements EchartsService {

    @Autowired
    private EchartsMapper echartsMapper;

    @Override
    public List<CopySku> histogram() {
        List<CopySku> list = echartsMapper.histogram();
        return list;
    }
}
