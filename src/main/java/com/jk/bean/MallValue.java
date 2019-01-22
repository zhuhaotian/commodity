package com.jk.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MallValue implements Serializable {
    private Integer id;

    private String shxzh;

    private String shfqy;

    private Integer shxm_id;

    private String shxzh_mch;

    private Date chjshj;

}