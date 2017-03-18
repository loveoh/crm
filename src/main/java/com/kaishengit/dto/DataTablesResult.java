package com.kaishengit.dto;

import java.util.List;

/**
 * Created by loveoh on 2017/3/18.
 */
public class DataTablesResult<T> {

    private String draw;
    private Long filterCount;
    private Long count;
    private List<T> list;

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public Long getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(Long filterCount) {
        this.filterCount = filterCount;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public DataTablesResult(String draw, Long filterCount, Long count, List<T> list) {

        this.draw = draw;
        this.filterCount = filterCount;
        this.count = count;
        this.list = list;
    }
}
