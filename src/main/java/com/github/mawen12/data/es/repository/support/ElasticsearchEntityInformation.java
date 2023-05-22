package com.github.mawen12.data.es.repository.support;

import java.io.Serializable;

public interface ElasticsearchEntityInformation<T, ID extends Serializable> {

    /**
     * 是否ES中不存在
     * @param entity
     * @return
     */
    boolean isNew(T entity);

    /**
     * 获取ID
     * @param entity
     * @return
     */
    ID getId(T entity);

    /**
     * 获取ID类型
     * @return
     */
    Class<ID> getIdType();

    /**
     * 获取ID属性名
     * @return
     */
    String getIdAttribute();

    /**
     * 获取索引名
     * @return
     */
    String getIndexName();

    /**
     * 获取类型
     * @return
     */
    String getType();

    /**
     * 获取版本
     * @param entity
     * @return
     */
    Long getVersion(T entity);

    /**
     * 获取父级ID
     * @param entity
     * @return
     */
    String getParentId(T entity);   
}
