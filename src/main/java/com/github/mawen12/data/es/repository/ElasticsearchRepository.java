package com.github.mawen12.data.es.repository;

import java.io.Serializable;

public interface ElasticsearchRepository<T, ID extends Serializable> {
    
    // region curd
    <S extends T> S save(S entity);

    <S extends T> Iterable<S> save(Iterable<S> entities);

    T findOne(ID id);

    boolean exists(ID id);

    Iterable<T> findAll();

    Iterable<T> findAll(Iterable<ID> ids);

    long count();

    void delete(ID id);

    void delete(T entity);

    void delete(Iterable<? extends T> entities);

    void deleteAll();
    // endregion


    // region page and sort

    // endregion

    // region search

    // endregion
}
