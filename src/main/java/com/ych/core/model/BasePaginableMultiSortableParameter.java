package com.ych.core.model;

import java.util.List;

/**
 * 基础可分页多可排序查询参数
 *
 * Created by U on 2017/7/5.
 */
public abstract class BasePaginableMultiSortableParameter implements MultiSortableParameter, PaginableParameter {

    /**
     * 起始页索引
     */
    private Integer pageIndex;

    /**
     * 起始行索引
     */
    private Long startIndex;

    /**
     * 页行数
     */
    private Integer pageSize;

    /**
     * 排序的参数列表
     */
    private List<SortParameter> sorts;

    @Override
    public Integer getPageIndex() {
        return pageIndex;
    }

    @Override
    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    @Override
    public Long getStartIndex() {
        return startIndex;
    }

    @Override
    public void setStartIndex(Long startIndex) {
        this.startIndex = startIndex;
    }

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public List<SortParameter> getSorts() {
        return sorts;
    }

    @Override
    public void setSorts(List<SortParameter> sorts) {
        this.sorts = sorts;
    }

}
