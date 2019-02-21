package com.jk.mapper;

import com.jk.bean.CopySku;

import java.util.List;
import java.util.Map;

public interface EchartsMapper {
    List<CopySku> histogram();

    List<Map<String, Object>> queryEcharts();
}
