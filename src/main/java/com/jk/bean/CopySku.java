package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class CopySku implements Serializable {
    private Integer id;
    private Integer shp_id;  //名称id
    private Integer kc;   //库存
    private Integer jg;  //价格
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date chjshj;   //创建时间
    private String sku_mch;   //sku名字
    private Integer sku_xl;   //销量
    private String kcdz;  //库存地址
    private List<SkuAttrValue> attrVal;
}
