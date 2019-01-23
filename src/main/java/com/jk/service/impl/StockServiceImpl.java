package com.jk.service.impl;

import com.github.pagehelper.PageHelper;
import com.jk.bean.*;
import com.jk.mapper.StockMapper;
import com.jk.service.StockService;
import com.jk.utils.ReturnPage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StockServiceImpl implements StockService{

    @Resource
    private StockMapper stockMapper;

    @Override
    public List<Class1> queryClass1() {
        return stockMapper.queryClass1();
    }

    @Override
    public List<Class2> getClass2ByFlbh1(Integer id) {
        return stockMapper.getClass2ByFlbh1(id);
    }

    @Override
    public List<TradeMark> getTradeMarkById(Integer id) {
        return stockMapper.getTradeMarkById(id);
    }

    @Override
    public List<Product> getProductById(Integer id) {
        return stockMapper.getProductById(id);
    }

    @Override
    public List<Attr> getAttrByFlbh2(Integer id) {
        return stockMapper.getAttrByFlbh2(id);
    }

    @Override
    public void addStock(Sku sku) {
        stockMapper.addStock(sku);
    }

    /**
     * 查询 stock
     */
    @Override
    public ReturnPage queryStock(Integer page, Integer rows) {
        List list = stockMapper.queryStock();
        PageHelper.startPage(page, rows);
        List listData = stockMapper.queryStock();
        ReturnPage returnPage = new ReturnPage(list.size(), listData);
        return returnPage;
    }

    @Override
    public List getSkuAttrValueById(Integer id) {
        return stockMapper.getSkuAttrValueById(id);
    }

    @Override
    public void addSku(CopySku copySku) {
        stockMapper.addSku(copySku);
        List<SkuAttrValue> skuAttrVal = copySku.getAttrVal();
        for (SkuAttrValue skuAttrValue : skuAttrVal) {
            if(skuAttrValue !=null){
                skuAttrValue.setShpId(copySku.getShp_id());
                skuAttrValue.setSkuId(copySku.getId());
                stockMapper.addStuAttrValue(skuAttrValue);
            }

        }

    }

}
