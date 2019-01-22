package com.jk.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class MallAttr {
    Integer id;
    String shxm_mch;
    Integer shfqy;
    Integer flbh2;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    Date chjshj;
    private Integer tempid;


}
