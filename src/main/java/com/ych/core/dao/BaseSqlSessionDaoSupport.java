package com.ych.core.dao;

import java.util.*;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.ych.core.model.MultiSortableParameter;
import com.ych.core.model.PagedList;
import com.ych.core.model.PaginableParameter;
import com.ych.core.model.SortableParameter;

/**
 * 基础的SqlSessionDaoSupport,封装一些通用操作
 * 
 * @author U
 *
 */
public class BaseSqlSessionDaoSupport extends SqlSessionDaoSupport {

	/**
	 * 分页查询,将pageSize和pageIndex进行转换,转换为参数startIndex和pageSize并放入parameter中一起查询
	 * 
	 * @param statement
	 *            查询语句
	 * @param parameter
	 *            参数
	 * @param pageSize
	 *            页行数
	 * @param pageIndex
	 *            页索引
	 * @return 查询结果
	 */
	public <T> PagedList<T> selectPaged(String statement, Map<String, ?> parameter, int pageSize, int pageIndex) {
		PagedList<T> ret = new PagedList<>();

		Map<String, Object> params = new HashMap<String, Object>(parameter);

		int retPageIdx = pageIndex;
		long count = getSqlSession().selectOne(statement + "_count", params);
		List<T> list;

		if (count == 0) {
			retPageIdx = 0;
			list = Collections.emptyList();
			ret.setPageCount(0);
		} else {
			int pageCount = (int) (count / pageSize);
			if (count % pageSize > 0) {
				if (retPageIdx > pageCount) {
					retPageIdx = pageCount;
				}
				pageCount += 1;
			} else {
				if (retPageIdx >= pageCount) {
					retPageIdx = pageCount - 1;
				}
			}

			params.put("startIndex", retPageIdx * pageSize);
			params.put("pageSize", pageSize);

			list = getSqlSession().selectList(statement, params);
			ret.setPageCount(pageCount);
		}

		ret.setList(list);
		ret.setPageIndex(retPageIdx);
		ret.setPageSize(pageSize);
		ret.setTotal(count);

		return ret;
	}

	/**
	 * 分页查询,parameter作为查询参数的condition属性,
	 * 将pageSize和pageIndex进行转换,转换为参数startIndex和pageSize并放入查询参数的paging属性中一起查询
	 * 
	 * @param statement
	 *            查询语句
	 * @param parameter
	 *            参数
	 * @param pageSize
	 *            页行数
	 * @param pageIndex
	 *            页索引
	 * @return 查询结果
	 */
	public <T> PagedList<T> selectPaged(String statement, Object parameter, int pageSize, int pageIndex) {
		PagedList<T> ret = new PagedList<>();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("condition", parameter);

		int retPageIdx = pageIndex;
		long count = getSqlSession().selectOne(statement + "_count", params);
		List<T> list;

		if (count == 0) {
			retPageIdx = 0;
			list = Collections.emptyList();
			ret.setPageCount(0);
		} else {
			int pageCount = (int) (count / pageSize);
			if (count % pageSize > 0) {
				if (retPageIdx > pageCount) {
					retPageIdx = pageCount;
				}
				pageCount += 1;
			} else {
				if (retPageIdx >= pageCount) {
					retPageIdx = pageCount - 1;
				}
			}

			Map<String, Object> paging = new HashMap<String, Object>();
			paging.put("startIndex", retPageIdx * pageSize);
			paging.put("pageSize", pageSize);

			params.put("paging", paging);

			list = getSqlSession().selectList(statement, params);
			ret.setPageCount(pageCount);
		}

		ret.setList(list);
		ret.setPageIndex(retPageIdx);
		ret.setPageSize(pageSize);
		ret.setTotal(count);

		return ret;
	}

	/**
	 * 分页查询,parameter作为查询参数的condition属性,
	 * 将pageSize和pageIndex进行转换,转换为参数startIndex和pageSize并放入查询参数的paging属性中一起查询
	 * 
	 * @param statement
	 *            查询语句
	 * @param parameter
	 *            参数
	 * @return 查询结果
	 */
	public <T> PagedList<T> selectPaged(String statement, PaginableParameter parameter) {
		PagedList<T> ret = new PagedList<>();

		int retPageIdx = parameter.getPageIndex();
		long count = getSqlSession().selectOne(statement + "_count", parameter);
		List<T> list;

		if (count == 0) {
			retPageIdx = 0;
			list = Collections.emptyList();
			ret.setPageCount(0);
		} else {
			int pageCount = (int) (count / parameter.getPageSize());
			if (count % parameter.getPageSize() > 0) {
				if (retPageIdx > pageCount) {
					retPageIdx = pageCount;
				}
				pageCount += 1;
			} else {
				if (retPageIdx >= pageCount) {
					retPageIdx = pageCount - 1;
				}
			}

			parameter.setStartIndex(Long.valueOf(retPageIdx * parameter.getPageSize()));

			list = getSqlSession().selectList(statement, parameter);
			ret.setPageCount(pageCount);
		}

		ret.setList(list);
		ret.setPageIndex(retPageIdx);
		ret.setPageSize(parameter.getPageSize());
		ret.setTotal(count);

		return ret;
	}

	/**
	 * 转换排序的列名
	 * 
	 * @param parameter
	 *            可排序参数
	 * @param columnMapper
	 *            列名映射
	 */
	protected void convertSortColumnName(SortableParameter parameter, Map<String, String> columnMapper) {
		if (parameter.getSort() != null) {
			parameter.setSort(columnMapper.get(parameter.getSort()));
		}
	}

    /**
     * 转换排序的列名
     *
     * @param parameter
     *            可排序参数
     * @param columnMapper
     *            列名映射
     */
    protected void convertSortColumnName(MultiSortableParameter parameter, Map<String, String> columnMapper) {
        if (CollectionUtils.isNotEmpty(parameter.getSorts())) {
            ArrayList<MultiSortableParameter.SortParameter> sorts = new ArrayList<>();

            for (MultiSortableParameter.SortParameter sort : parameter.getSorts()) {
                MultiSortableParameter.SortParameter replace = ObjectUtils.clone(sort);
                replace.setSort(columnMapper.get(sort.getSort()));

                if (replace.getSort() != null) {
                    sorts.add(replace);
                }
            }

            parameter.setSorts(sorts.size() > 0 ? sorts : null);
        }
    }

}
