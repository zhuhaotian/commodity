package com.jk.service;

import com.jk.bean.CopySku;

import java.util.List;
import java.util.Map;

public interface EchartsService {
    List<CopySku> histogram();

    List<Map<String, Object>> queryEcharts();
}
