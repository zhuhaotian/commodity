package com.jk.mapper;

import com.jk.bean.Title;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TitleMapper {


    List getTitle();

    void addTitle(Title title);

    void deleteById(@Param("id") String id);

    Title getTitleById(String id);

    void updateById(Title title);
}
