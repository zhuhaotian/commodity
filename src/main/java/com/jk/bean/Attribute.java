package com.jk.bean;

import lombok.Data;

import java.util.List;

@Data
public class Attribute {

    private Integer id;//(编号)             PKInteger
    private String shxzh;//(属性值)        String(100)
    private String shfqy;//(是否启用)      String(1)
    private Integer shxm_id;//(属性id)      Integer
    private String shxzh_mch;//(属性值名)  String(100)
    private String chjshj;//(创建时间)     Date

    private List<MallAttr> list;

    private String shxmMch ;     //第一个表属性名

    String shxmValue;

    //临时字段
    Integer queryid;
}
