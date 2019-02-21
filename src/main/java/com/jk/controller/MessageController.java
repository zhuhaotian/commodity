package com.jk.controller;

import com.jk.bean.Product;
import com.jk.service.MessageService;
import com.jk.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
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

    String format = "";
    String resultUrl ="";
    //poi导出   成excel
    @ResponseBody
    @RequestMapping("save")
    public String save(@RequestParam("id[]") String[] id, HttpServletResponse response,HttpServletRequest request) throws Exception{


        String sheetName="商品列表";
        String titleName="我的列表";
        String[] headers = { "商品ID", "商品名称", "商品图片", "分类编号1" ,"分类编号2","品牌id","创建时间","商品描述"};
        List<Product> dataSet = messageService.selectBookList(id);
        /*生成桌面路径*//*
        FileSystemView fsv = FileSystemView.getFileSystemView();
        File com = fsv.getHomeDirectory();

        *//*时间戳*//*
        SimpleDateFormat sb = new SimpleDateFormat("yyyy-MM-ddHHmmss");
        format = sb.format(new Date());

        resultUrl = com + "\\" + format + ".xls";*/

        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition", "attachment;filename=" + resultUrl);

        String pattern = "yyyy-MM-dd";
        ExportExcel.exportExcel(sheetName, titleName, headers, dataSet, resultUrl, pattern);
        return "success";
    }

    //poi导入
    @ResponseBody
    @RequestMapping("importExcel")
    public String importExcel(MultipartFile file) throws Exception{
    String filePath = file.getOriginalFilename();
    // System.out.println(filePath);
    String path = filePath.substring(filePath.lastIndexOf("."));
        if (path.equals(".xls")) {
        int startRow = 2;//从表格的哪一行开始读取
        int endRow = 0;
        List<Product> bookList = (List<Product>) ImportExcel.importExcel(file.getInputStream(), startRow, endRow, Product.class);
        for (Product book : bookList) {
            book.setId(null);
            messageService.insertBook(book);
        }
        return "1";//成功
    } else {
        return "0";
    }
  }


}
