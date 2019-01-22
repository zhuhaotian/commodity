package com.jk.mapper;

import com.jk.bean.Attribute;
import com.jk.bean.MallAttr;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface PropertyMapper {

   // @Select("select count(*) from t_mall_value ")
   // int queryListToTalCount(HashMap<String, Object> hashMap);

    @Select("select id from t_mall_attr t where shxm_mch = #{shxm_mch}")
    Integer getArrrId(String shxm_mch);

     void addMallAttr(MallAttr arr);

    void addAttr(@Param("attribute") ArrayList<Attribute> attribute);

    List queryListAttribute(Attribute attribute);
}
