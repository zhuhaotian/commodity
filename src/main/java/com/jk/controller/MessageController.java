package com.jk.controller;

import com.jk.bean.Product;
import com.jk.service.MessageService;
import com.jk.utils.FileUtil;
import com.jk.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MessageController {
    @Autowired
    private MessageService messageService;
    //跳转页面
    @RequestMapping("toMessage")
    public String toMassage(){

        return "MessageList";
    }

    //跳转页面
    @RequestMapping("toUpdete")
    public String toUpdete(){

        return "updeteMessage";
    }

    //分页
    @RequestMapping("empQuery")
    @ResponseBody
    public PageResult queryUser(Integer page, Integer rows, Product product){
        return messageService.queryUser(page,rows,product);
    }

    //图片上传
    @RequestMapping("uploadNewsImg")
    @ResponseBody
    public String uploadNewsImg(MultipartFile newsimg, HttpServletRequest request) {
        String fileUpload = FileUtil.FileUpload(newsimg, request);
        return fileUpload;
    }

    //删除
    @RequestMapping("removeEmp")
    @ResponseBody
    public String removeEmp(Integer id){
        messageService.removeEmp(id);
                return "1";
    }
    //批删
    @RequestMapping("removeAll")
    @ResponseBody
    public String removeAll(@RequestParam("id[]") String[] id){
        messageService.removeAll(id);
        return "1";
    }
    //修改回显
    @RequestMapping("selectQueryById")
    @ResponseBody
    public Product selectQueryById(Integer id){

        return messageService.selectQueryById(id);
    }

    //修改
    @RequestMapping("updeteByEmp")
    @ResponseBody
    public String updeteByEmp(Product product){

        messageService.updeteByEmp(product);
        return "1";
    }
}
