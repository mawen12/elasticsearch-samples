package com.github.mawen12.data.es.core.mapping;

public interface ElasticsearchPersistentEntity<T> {

    String getIndexName();

    String getIndexType();

    short getShards();

    short getReplicas();

    String getRefreshInterval();
    
    String getIndexStoreType();

    ElasticsearchPersistentEntity getVersionProperty();

    String getParentType();

    ElasticsearchPersistentEntity getParentIdProperty();

    String settingPath();
}
