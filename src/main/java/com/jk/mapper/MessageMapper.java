package com.jk.mapper;

import com.jk.bean.Product;

import java.util.HashMap;
import java.util.List;

public interface MessageMapper {


    int querynameCount(HashMap<String, Object> hashMap);

    List<Product> querynameList(HashMap<String, Object> hashMap);

    void removeEmp(Integer id);

    void removeAll(String[] id);

    Product selectQueryById(Integer id);

    void updeteByEmp(Product product);

    public void addfile(String count);

    public void addgood(Product Product);

    List<Product> selectBookList(String[] id);

    void insertBook(Product book);
}
