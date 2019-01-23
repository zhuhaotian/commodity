package com.jk.service.impl;

import com.jk.bean.ImgBean;
import com.jk.mapper.ImgMapper;
import com.jk.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    private ImgMapper imgMapper;

    @Override
    public List<ImgBean> ImgCon(ImgBean imgBean) {

        return imgMapper.ImgCon(imgBean);
    }
}
