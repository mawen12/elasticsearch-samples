package com.github.mawen12.data.es.core.mapping;

public interface ElasticsearchPersistentEntity<T> {

    IndexCoordinates getIndexCoordinates();

    String getIndexName();

    String getIndexType();

    short getShards();

    short getReplicas();

    String getRefreshInterval();
    
    String getIndexStoreType();

    ElasticsearchPersistentProperty getIdProperty();

    ElasticsearchPersistentEntity getVersionProperty();

    String getParentType();

    ElasticsearchPersistentEntity getParentIdProperty();

    String settingPath();

    Class<T> getType();


}
