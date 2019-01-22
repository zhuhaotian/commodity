package com.jk.bean;

import lombok.Data;

@Data
public class Image {
    private Integer Id;//(编号)        PKInteger
    private String zy;//(作用)        String(100)
    private Integer shp_id;//(商品id)  Integer
    private String url;//(图片地址)   String(100)
}
