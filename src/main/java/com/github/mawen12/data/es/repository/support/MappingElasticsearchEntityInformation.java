package com.github.mawen12.data.es.repository.support;

import java.io.Serializable;

import com.github.mawen12.data.es.core.mapping.SimpleElasticsearchPersistentEntity;

public class MappingElasticsearchEntityInformation<T, ID extends Serializable> extends AbstractElasticsearchEntityInformation<T, ID> {

    private final SimpleElasticsearchPersistentEntity<T> entityMetadata;


    @Override
    public ID getId(T entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    @Override
    public Class<ID> getIdType() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdType'");
    }

    @Override
    public String getIdAttribute() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getIdAttribute'");
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
