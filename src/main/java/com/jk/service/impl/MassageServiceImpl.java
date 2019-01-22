package com.jk.service.impl;

import com.jk.bean.Product;
import com.jk.mapper.MessageMapper;
import com.jk.service.MessageService;
import com.jk.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MassageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;


    @Override
    public PageResult queryUser(Integer page, Integer rows, Product product) {
        PageResult pageResult = new PageResult();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("product", product);
        int count = messageMapper.querynameCount(hashMap);
        pageResult.setTotal(count);
        hashMap.put("startIndex", (page - 1) * rows);
        hashMap.put("endIndex", rows);
        List<Product> list = messageMapper.querynameList(hashMap);
        pageResult.setRows(list);
        return pageResult;
    }

    @Override
    public void removeEmp(Integer id) {
        messageMapper.removeEmp(id);
    }

    @Override
    public void removeAll(String[] id) {
        messageMapper.removeAll(id);
    }

    @Override
    public Product selectQueryById(Integer id) {
        return messageMapper.selectQueryById(id);
    }

    @Override
    public void updeteByEmp(Product product) {
        messageMapper.updeteByEmp(product);
    }


}
