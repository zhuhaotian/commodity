package com.jk.controller;

import com.jk.bean.CopySku;
import com.jk.service.EchartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EchartsController {

    @Autowired
    private EchartsService echartsService;

    @RequestMapping("Toecharts")
    public String Toecharts(){

        return "echartsList";
    }

    @RequestMapping("Toline")
    public String Toline(){

        return "echartsLineChart";
    }

    @RequestMapping("histogram")
    @ResponseBody
    public Map<String, Object> histogram(){
        HashMap<String, Object> params = new HashMap<>();
        ArrayList<String> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        List<CopySku> copySku = echartsService.histogram();
        for (CopySku sku : copySku) {
            a.add(sku.getSku_mch());
            b.add(Integer.valueOf(sku.getKc()));
        }
        params.put("sku_mch",a);
        params.put("kc",b);
        System.out.println("=================>"+params);
        return params;
    }
}
