package com.github.mawen12.data.es.core;

import java.util.List;

import com.github.mawen12.data.es.core.query.GetQuery;
import com.github.mawen12.data.es.core.query.Query;
import com.github.mawen12.data.es.core.query.SearchQuery;

public interface ElasticsearchOperations {

    // region crud
    <T> T save(T entity);

    <T> Iterable<T> save(Iterable<T> entities);

    <T> T get(String id, Class<T> clazz);

    <T> List<T> list(Query query, Class<T> clazz);

    boolean exists(String id, Class<?> clazz);

    String delete(String id, Class<?> entityType);

    String delete(Object entity);
    // endregion

    // region query
    <T> T queryForObject(GetQuery query, Class<T> clazz);

    <T> long count(SearchQuery query, Class<T> clazz);

    <T> long count(SearchQuery query);
    // endregion

}
