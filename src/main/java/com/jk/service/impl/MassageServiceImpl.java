package com.jk.service.impl;

import com.jk.bean.Product;
import com.jk.mapper.MessageMapper;
import com.jk.service.MessageService;
import com.jk.utils.ResultPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
public class MassageServiceImpl implements MessageService {
    @Resource
    private MessageMapper messageMapper;


    @Override
    public ResultPage queryUser(Integer page, Integer rows, Product product) {
        ResultPage pageResult = new ResultPage();
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

    @Override
    public void addfile(String count) {

        messageMapper.addfile(count);
    }
    public void addgood(Product Product){

        messageMapper.addgood(Product);

    }
    //poi导出
    @Override
    public List<Product> selectBookList(String[] id) {
        return messageMapper.selectBookList(id);
    }
    //poi导入
    @Override
    public void insertBook(Product book) {
        messageMapper.insertBook(book);
    }


}
