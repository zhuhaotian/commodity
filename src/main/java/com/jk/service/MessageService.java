package com.jk.service;

import com.jk.bean.Product;
import com.jk.utils.ResultPage;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface MessageService {


    ResultPage queryUser(Integer page, Integer rows, Product product);

    void removeEmp(Integer id);

    void removeAll(String[] id);

    Product selectQueryById(Integer id);

    void updeteByEmp(Product product);


    public void addfile(String count);

    public void addgood(Product Product);
    //poi导出
    @Async
    List<Product> selectBookList(String id);
    //poi导入
    @Async
    void insertBook(Product book);
}
