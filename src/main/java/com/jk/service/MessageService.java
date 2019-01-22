package com.jk.service;

import com.jk.bean.Product;
import com.jk.utils.PageResult;

public interface MessageService {


    PageResult queryUser(Integer page, Integer rows, Product product);

    void removeEmp(Integer id);

    void removeAll(String[] id);

    Product selectQueryById(Integer id);

    void updeteByEmp(Product product);
}
