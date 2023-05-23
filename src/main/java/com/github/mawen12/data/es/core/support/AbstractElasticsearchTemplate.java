package com.github.mawen12.data.es.core.support;

import java.util.Objects;

import com.github.mawen12.data.es.core.ElasticsearchOperations;
import com.github.mawen12.data.es.core.mapping.ElasticsearchPersistentEntity;
import com.github.mawen12.data.es.core.mapping.IndexCoordinates;

public abstract class AbstractElasticsearchTemplate implements ElasticsearchOperations {
    

    @Override
    public <T> T save(T entity) {

        Objects.requireNonNull(entity, () -> "entity must not be null");

        return save(entity, getIndexCoordinatesFor(entity.getClass()));
    }   
    
    protected abstract <T> T save(T entity, IndexCoordinates indexCoordinates);

    @Override
    public <T> T get(String id, Class<T> clazz) {
        return get(id, clazz, getIndexCoordinatesFor(clazz));
    }

    protected abstract <T> T get(String id, Class<T> clazz, IndexCoordinates indexCoordinates);

    @Override
    public String delete(String id, Class<?> entityType) {
        return delete(id, entityType, getIndexCoordinatesFor(entityType));
    }

    protected abstract String delete(String id, Class<?> entityType, IndexCoordinates indexCoordinates);

    protected IndexCoordinates getIndexCoordinatesFor(Class<?> clazz) {
        return getRequiredPersistentEntity(clazz).getIndexCoordinates();            
    }

    ElasticsearchPersistentEntity<?> getRequiredPersistentEntity(Class<?> clazz) {
        return null;
    }
}
