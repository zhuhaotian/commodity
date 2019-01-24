package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.Product;
import com.jk.bean.Title;
import com.jk.mapper.TitleMapper;
import com.jk.service.TitleService;
import com.jk.utils.ResultPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class TitleServiceImpl implements TitleService {
    @Resource
    TitleMapper mapper;
   @Override
    public ResultPage getTitle(Integer page, Integer rows) {

        List list = mapper.getTitle();
        PageHelper.startPage(page, rows);
        List list2 = mapper.getTitle();
        ResultPage pageResult = new ResultPage(list.size(), list2);
        return pageResult;

    }

    @Override
    public void addTitle(Title title) {
       if(title.getId()!=null){
           mapper.updateById(title);
       }
        mapper.addTitle(title);
    }

    @Override
    public void deleteById(String id) {
        mapper.deleteById(id);
    }

    @Override
    public Title getTitleById(String id) {

        return mapper.getTitleById(id);
    }

}
