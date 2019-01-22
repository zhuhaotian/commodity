package com.jk.controller;

import com.jk.bean.Attribute;
import com.jk.bean.MallAttr;
import com.jk.service.PropertyService;
import com.jk.utils.QueryParam;
import com.jk.utils.ResultPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;

@Controller
@RequestMapping("attr")
public class PropertyController {

   @Autowired
   private PropertyService service;

   //跳转到页面的方法
   @RequestMapping("toview")
   public String toView(String viewname){

      return viewname;
   }
   /**
    * 查询属性值
    * @param attribute
    * @return
    */
   @RequestMapping("queryListAttribute")
   @ResponseBody
   public ResultPage queryListAttribute(Integer rows, Integer page, Attribute attribute){

      return service.queryListAttribute(rows, page,attribute);
   }

   /**
    * 新增属性
    * @param arr
    * @param param
    * @return
    */
   @ResponseBody
   @RequestMapping("addAttr")
   public String addAttr(MallAttr arr, QueryParam param) {
      ArrayList<Attribute> attribute = param.getAttribute();
      Iterator<Attribute> iterator = attribute.iterator();
      while(iterator.hasNext()) {
         Attribute arrt= iterator.next();
         if(arrt.getShxzh()==null) {
            iterator.remove();
         }
      }
      service.addAttr(arr,param);
      return "1";
   }
}
