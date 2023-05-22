package com.github.mawen12.data.es.repository.support;

import java.io.Serializable;

import com.github.mawen12.data.es.repository.ElasticsearchRepository;

public abstract class AbstractElasticsearchRepository<T, ID extends Serializable> implements ElasticsearchRepository<T, ID> {
    
    protected Class<T> entityClass;

    
}
