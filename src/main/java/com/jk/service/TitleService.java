package com.jk.service;

import com.jk.bean.Title;
import com.jk.utils.ResultPage;

public interface TitleService {
    ResultPage getTitle(Integer page, Integer rows);

    void addTitle(Title title);

    void deleteById(String id);

    Title getTitleById(String id);
}
