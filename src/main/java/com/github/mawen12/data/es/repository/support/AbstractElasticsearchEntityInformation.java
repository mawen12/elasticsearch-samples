package com.github.mawen12.data.es.repository.support;

import java.io.Serializable;
import java.util.Objects;

public abstract class AbstractElasticsearchEntityInformation<T, ID extends Serializable> implements ElasticsearchEntityInformation<T, ID> {
    
    private final Class<T> domainClass;

    public AbstractElasticsearchEntityInformation(Class<T> domainClass) {
        Objects.requireNonNull(domainClass);

        this.domainClass = domainClass;
    }

    public boolean isNew(T entity) {
        
        ID id = getId(entity);
        Class<ID> idType = getIdType();

        if (!idType.isPrimitive()) {
            return id == null;
        }

        if (id instanceof Number) {
            return ((Number) id).longValue() == 0L;
        }        

        throw new IllegalArgumentException(String.format("Unsupported primitive id type %s!", idType));

    }

    public Class<T> getJavaType() {
        return domainClass;
    }
}
