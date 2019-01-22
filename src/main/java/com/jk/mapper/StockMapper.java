package com.jk.mapper;

import com.jk.bean.*;

import java.util.List;

public interface StockMapper {
    /**
     * 查询一级
     * @return
     */
    List<Class1> queryClass1();

    /**
     * 查询2级
     * @return
     */
    List<Class2> getClass2ByFlbh1(Integer id);

    /**
     * 根据id查询品牌数据
     * @return
     */
    List<TradeMark> getTradeMarkById(Integer id);

    /**
     * 根据id查询商品
     * @return
     */
    List<Product> getProductById(Integer id);

    /**
     * 根据class id查询属性
     * @return
     */
    List<Attr> getAttrByFlbh2(Integer id);

    /**
     * 新增
     * @param sku
     */
    void addStock(Sku sku);

    List queryStock();

    List getSkuAttrValueById(Integer id);

    void addStuAttrValue(SkuAttrValue skuAttrValue);

    void addSku(CopySku copySku);
}
