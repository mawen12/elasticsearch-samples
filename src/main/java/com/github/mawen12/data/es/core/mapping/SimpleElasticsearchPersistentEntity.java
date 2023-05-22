package com.github.mawen12.data.es.core.mapping;

import java.io.Serializable;

import lombok.Data;

@Data
public class SimpleElasticsearchPersistentEntity<T> implements ElasticsearchPersistentEntity<T>,Serializable {

    /**
     * 索引名
     */
    private String indexName;

    /**
     * 索引类型
     */
    private String indexType;

    /**
     * 分片数
     */
    private short shards;

    /**
     * 副本数
     */
    private short replicas;

    /**
     * 路由
     */
    private String routing;

    /**
     * 是否将id保存到source
     */
    private boolean storeIdInSource;

    /**
     * 是否将version保存到source
     */
    private boolean storeVersionInSource;

    /**
     * 刷新间隔
     */
    private String refreshInterval;

    private String indexStoreType;

    private String parentType;

    private String settingPath;

    @Override
    public ElasticsearchPersistentEntity getVersionProperty() {
        throw new UnsupportedOperationException("Unimplemented method 'getVersionProperty'");
    }

    @Override
    public ElasticsearchPersistentEntity getParentIdProperty() {
        throw new UnsupportedOperationException("Unimplemented method 'getParentIdProperty'");
    }

    @Override
    public String settingPath() {
        return settingPath;
    }

}
