package com.jk.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * easyui分页返回工具类
 *
 * @author songxj
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultPage {

    private Integer total = 0;

    private List<?> rows;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;

    }


}
