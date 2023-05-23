package com.github.mawen12.data.es.repository.support;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Objects;

import org.elasticsearch.index.query.QueryBuilders;

import com.github.mawen12.data.es.core.ElasticsearchOperations;
import com.github.mawen12.data.es.core.query.GetQuery;
import com.github.mawen12.data.es.core.query.IndexQuery;
import com.github.mawen12.data.es.core.query.NativeSearchQuery;
import com.github.mawen12.data.es.core.query.NativeSearchQueryBuilder;
import com.github.mawen12.data.es.core.query.SearchQuery;
import com.github.mawen12.data.es.repository.ElasticsearchRepository;

public abstract class AbstractElasticsearchRepository<T, ID extends Serializable> implements ElasticsearchRepository<T, ID> {
    
    protected Class<T> entityClass;

    protected ElasticsearchOperations elasticsearchOperations;

    protected ElasticsearchEntityInformation<T, ID> entityInformation;

    public AbstractElasticsearchRepository() {

    }   
    
    public AbstractElasticsearchRepository(ElasticsearchOperations elasticsearchOperations) {
        Objects.requireNonNull(elasticsearchOperations);
        setElasticsearchOperations(elasticsearchOperations);
    }

    public AbstractElasticsearchRepository(ElasticsearchEntityInformation<T, ID> metadata,
                                            ElasticsearchOperations elasticsearchOperations) {
        this(elasticsearchOperations);
        Objects.requireNonNull(metadata);
        this.entityInformation = metadata;
        setEntityClass(this.entityInformation.getJavaType());
    }

    public final void setElasticsearchOperations(ElasticsearchOperations elasticsearchOperations) {
        Objects.requireNonNull(elasticsearchOperations, () -> "ElasticsearchOperations must not be null.");
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public final void setEntityClass(Class<T> entityClass) {
        Objects.requireNonNull(entityClass, () -> "EntityClass must not be null.");
        this.entityClass = entityClass;
    }

    public Class<T> getEntityClass() {
        if (isEntityClassSet()) {
            this.entityClass = resolveReturnedClassFromGenericType();
        }
        return entityClass;
    }

    private boolean isEntityClassSet() {
        return entityClass != null;
    }

    private Class<T> resolveReturnedClassFromGenericType() {
        ParameterizedType parameterizedType = resolveReturnedClassFromGenericType(getClass());
        return (Class<T>)parameterizedType.getActualTypeArguments()[0];
    }

    private ParameterizedType resolveReturnedClassFromGenericType(Class<?> clazz) {
        Object genericSuperClass = clazz.getGenericSuperclass();
        if (genericSuperClass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericSuperClass;
            Type rawtype = parameterizedType.getRawType();
            if (SimpleElasticsearchRepository.class.equals(rawtype)) {
                return parameterizedType;
            }

        }
        return resolveReturnedClassFromGenericType(clazz.getSuperclass());
    }

    protected abstract String stringIdRepresentation(ID id);

    protected ID extractidFromBean(T entity) {
        if (entityInformation != null) {
            return entityInformation.getId(entity);
        }
        return null;
    }

    protected Long extractVersionFromBean(T entity) {
        if (entityInformation != null) {
            return entityInformation.getVersion(entity);
        }
        return null;
    }

    private String extractParentIdFromBean(T entity) {
        if (entityInformation != null) {
            return entityInformation.getParentId(entity);
        }
        return null;
    }

    // region crud
    @Override
    public T findOne(ID id) {
        GetQuery query = new GetQuery();
        query.setId(stringIdRepresentation(id));
        return elasticsearchOperations.queryForObject(query, getEntityClass());
    }

    @Override
    public Iterable<T> findAll() {
        int itemCount = (int) this.count();
        if (itemCount == 0) {
            return Collections.emptyList();
        }
        return null;
    }

    @Override
    public Iterable<T> findAll(Iterable<ID> ids){
        Objects.requireNonNull(ids, () -> "ids cannot be null.");

        return null;
    }

    @Override
    public long count() {
        SearchQuery query = new NativeSearchQueryBuilder().withQuery(QueryBuilders.matchAllQuery()).build();
        return elasticsearchOperations.count(query, getEntityClass());
    }

    @Override
    public <S extends T> S save(S entity) {
        Objects.requireNonNull(entity, "Cannot save 'null' entity");
        return entity;
    }

    private IndexQuery createIndexQuery(T entity) {
        IndexQuery query = new IndexQuery();
        query.setObject(entity);
        query.setId(stringIdRepresentation(extractidFromBean(entity)));
        query.setVersion(extractVersionFromBean(entity));
        return query;
    }
    // endregion
}
