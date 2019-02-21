package com.jk.service.impl;

import com.jk.bean.CopySku;
import com.jk.mapper.EchartsMapper;
import com.jk.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EchartsServiceImpl implements EchartsService {

    @Autowired
    private EchartsMapper echartsMapper;

    @Override
    public List<CopySku> histogram() {
        List<CopySku> list = echartsMapper.histogram();
        return list;
    }

    @Override
    public List<Map<String, Object>> queryEcharts() {
        List<Map<String, Object>> list = echartsMapper.queryEcharts();
        return list;
    }
}
