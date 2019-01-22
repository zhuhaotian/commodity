package com.jk.service;

import com.jk.bean.*;
import com.jk.utils.ReturnPage;

import java.util.List;

public interface StockService {
    List<Class1> queryClass1();

    List<Class2> getClass2ByFlbh1(Integer id);

    List<TradeMark> getTradeMarkById(Integer id);

    List<Product> getProductById(Integer id);

    List<Attr> getAttrByFlbh2(Integer id);

    void addStock(Sku sku);

    ReturnPage queryStock(Integer page, Integer rows);

    List getSkuAttrValueById(Integer id);

    void addSku(CopySku copySku);
}
