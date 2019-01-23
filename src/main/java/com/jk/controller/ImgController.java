package com.jk.controller;

import com.jk.bean.ImgBean;
import com.jk.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ImgController {

    @Autowired
    private ImgService imgService;

    @RequestMapping("toMe")
    public String toMassage(){

        return "imgss";
    }

    @RequestMapping("ImgCon")
    @ResponseBody
    public List<ImgBean> ImgCon(@RequestBody ImgBean imgBean){
        List<ImgBean> list = imgService.ImgCon(imgBean);
        System.out.println(list);
        return list;
    }
}
