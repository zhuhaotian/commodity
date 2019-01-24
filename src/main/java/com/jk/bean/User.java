package com.jk.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Integer id;

    private String yhMch;

    private String yhNch;


    private String yhMm;

    private String yhXm;

    private String yhShjh;

    private String yhYx;

    private String yhTx;

    private Integer yhJb;  //

    private String rememberPwd;  //记住密码


}