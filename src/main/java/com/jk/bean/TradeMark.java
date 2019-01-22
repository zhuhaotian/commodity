package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class TradeMark implements Serializable {
    private Integer id;

    /**
     * 品牌名称
     */
    private String ppmch;

    /**
     * 品牌图片
     */
    private String url;

}