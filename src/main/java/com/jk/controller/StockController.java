package com.jk.controller;

import com.jk.bean.*;
import com.jk.service.StockService;
import com.jk.utils.ReturnPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("stock")
public class StockController {


    @Resource
    private StockService stockService;

    /**
     * 查询第一层类别
     * @return
     */
    @ResponseBody
    @RequestMapping("queryClass1")
    public List<Class1> queryClass1(){
        return stockService.queryClass1();
}

    /**
     * 查询第2层类别
     * @return
     */
    @ResponseBody
    @RequestMapping("getClass2ByFlbh1")
    public List<Class2> getClass2ByFlbh1(Integer id){
        return stockService.getClass2ByFlbh1(id);
    }

    /**
     * 查询品牌
     * @return
     */
    @ResponseBody
    @RequestMapping("getTradeMarkById")
    public List<TradeMark> getTradeMarkById(Integer id){
        return stockService.getTradeMarkById(id);
    }

    /**
     * 根据品牌id查询
     * @return
     */
    @ResponseBody
    @RequestMapping("getProductById")
    public List<Product> getProductById(Integer id){
        return stockService.getProductById(id);
    }

    /**
     *查询属性名
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("getAttrByFlbh2")
    public List<Attr> getAttrByFlbh2(Integer id){
        return stockService.getAttrByFlbh2(id);
    }

    @ResponseBody
    @RequestMapping("addStock")
    public String addStock(Sku sku){
        stockService.addStock(sku);
        return "1";
    }

    @RequestMapping("toStockAdd")
    public String toStockAdd(){
        return "stockAdd";
    }

    @RequestMapping("toView")
    public String toView(){

        return "stockList";
    }

    /**
     *
     * 查询 stock  总查询
     */
    @RequestMapping("queryStock")
    @ResponseBody
    public ReturnPage queryStock(Integer page, Integer rows){
        ReturnPage returnPage=stockService.queryStock(page,rows);
        return returnPage;
    }

    /**
     *查询属性值
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("getSkuAttrValueById")
    public List getSkuAttrValueById(Integer id){
        return stockService.getSkuAttrValueById(id);
    }

    @ResponseBody
    @RequestMapping("addSku")
    public String addSku(CopySku copySku){
        stockService.addSku(copySku);
        return "1";
    }
}
