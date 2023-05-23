package com.github.mawen12.data.es.repository.support;

import java.io.Serializable;

import com.github.mawen12.data.es.core.mapping.ElasticsearchPersistentEntity;
import com.github.mawen12.data.es.core.mapping.ElasticsearchPersistentProperty;

public class MappingElasticsearchEntityInformation<T, ID extends Serializable> extends AbstractElasticsearchEntityInformation<T, ID> {

    private final ElasticsearchPersistentEntity<T> entityMetadata;

    private final String indexName;

    private final String type;

    private Class<?> idClass;

    public MappingElasticsearchEntityInformation(ElasticsearchPersistentEntity<T> entity) {
        this(entity, null, null);
    }

    public MappingElasticsearchEntityInformation(ElasticsearchPersistentEntity<T> entity, String indexName, String type) {
        super(entity.getType());
        this.entityMetadata = entity;
        this.indexName = indexName;
        this.type = type;
        this.idClass = entity.getIdProperty().getType();
    }

    @Override
    public ID getId(T entity) {
        ElasticsearchPersistentProperty id = entityMetadata.getIdProperty();
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    @Override
    public Class<ID> getIdType() {
        return (Class<ID>) idClass;
    }

    @Override
    public String getIdAttribute() {
        return entityMetadata.getIdProperty().getField().getName();
    }

    @Override
    public String getIndexName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIndexName'");
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getType'");
    }

    @Override
    public Long getVersion(T entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getVersion'");
    }

    @Override
    public String getParentId(T entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getParentId'");
    }
    

    

}
