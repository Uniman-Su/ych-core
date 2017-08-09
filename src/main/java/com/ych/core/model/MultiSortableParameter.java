package com.ych.core.model;

import java.util.List;

/**
 * 多列可排序参数
 * <p>
 * Created by U on 2017/7/5.
 */
public interface MultiSortableParameter {

    /**
     * @return 排序参数列表
     */
    List<SortParameter> getSorts();

    /**
     * @param sort
     *         排序参数列表
     */
    void setSorts(List<SortParameter> sort);

    /**
     * 排序的参数
     */
    class SortParameter extends BaseSortableParameter implements Cloneable {

        /**
         * 构造方法
         *
         * @param sort
         *         排序的列
         */
        public SortParameter(String sort) {
            setSort(sort);
        }

        /**
         * 构造方法
         *
         * @param sort
         *         排序的列
         * @param order
         *         排序方向
         */
        public SortParameter(String sort, SortOrder order) {
            setSort(sort);
            setOrder(order);
        }

    }

}
