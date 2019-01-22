package com.jk.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class SkuAttrValue{

    private Integer id;
    private Integer shxmId;  //属性名id
    private Integer shxzhId;   //属性值id
    private Integer shpId;  //商品id
    private String isSku;  //是否sku

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GTM+8")
    private Date chjshj;  //创建时间
    private Integer skuId;

    //临时字段
    private String sku_mch;

    private Integer jg;  //价格(Sku表)

    private Integer sku_xl;   //销量

    private String kcdz;  //库存地址

    private String flmch1;  //(class1表 )

    private String flmch2;  //(class2 表)

    private String shp_mch;//(商品名称)? String(100)

    private String shp_msh;//(商品描述)? String(1000)

    private String shxm_mch;//(属性值名)? String(100)

    private String shxzh;

}
