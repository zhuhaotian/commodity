package com.jk.controller;

import com.jk.bean.Product;
import com.jk.bean.Title;
import com.jk.service.TitleService;
import com.jk.utils.ResultPage;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("tit")
public class TitleController {
    @Autowired
    TitleService service;

    @ResponseBody
    @RequestMapping("getTitle")
    public ResultPage getTitle(Integer page, Integer rows){
        return service.getTitle(page,rows);
    }

    @ResponseBody
    @RequestMapping("addTitle")
    public String addTitle(Title title){
        service.addTitle(title);
        return "1";
    }
    @ResponseBody
    @RequestMapping("deleteTiTById")
    public String deleteById(String id){
        service.deleteById(id);
        return "1";
    }
    @RequestMapping("totitle")
    public String totitle(){
        return "titleShow";
    }
    @RequestMapping("toAdd")
    public String toAdd(){
        return "addTitle";
    }
    @RequestMapping("todd")
    public String toAdd(String id, HttpServletRequest request) {
         request.setAttribute("id",id);
        return "addTitle";
    }

    @RequestMapping("getTitleById")
    public String getTitleById(String id,Model model){

        Title title = service.getTitleById(id);
        model.addAttribute("id",title.getId());
        model.addAttribute("text",title.getText());
        model.addAttribute("href",title.getHref());
        return "addTitle";
    }
}
