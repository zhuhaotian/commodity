package com.jk.controller;

import com.jk.bean.Product;
import com.jk.service.MessageService;
import com.jk.utils.FileUtil;
import com.jk.utils.OssUpFileUtil;
import com.jk.utils.ResultPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

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
    public ResultPage queryUser(Integer page, Integer rows, Product product){
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
    //新增页面
    @RequestMapping("goodadd")
    public String good(){

        return "togood";
    }
    @RequestMapping("goodaddtwo")
    public String goodaddtwo(){

        return "message";
    }
    //新增商品
    @ResponseBody
    @RequestMapping("addgood")
    public String addgood(Product Product){
        System.out.println(Product);
        messageService.addgood(Product);

        return "1";
    }
    //新增图片
    @ResponseBody
    @PostMapping("toUploadBlog")
    public String toUploadBlog(@RequestParam("file") MultipartFile file){
        Map<String, Object> stringObjectMap = OssUpFileUtil.uploadFile(file);
        System.out.println(stringObjectMap);
        String count = "";
        for (String key : stringObjectMap.keySet()) {
            Object o = stringObjectMap.get(key);
            System.out.println("key: " + key + " value: " + o);
            if(key=="url"){
                count+=o;
                messageService.addfile(count);
            }
        }
        return count;
    }




}
