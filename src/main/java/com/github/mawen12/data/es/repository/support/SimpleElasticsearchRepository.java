package com.github.mawen12.data.es.repository.support;

import com.github.mawen12.data.es.core.ElasticsearchOperations;
import com.github.mawen12.data.es.core.ElasticsearchTemplate;

public class SimpleElasticsearchRepository<T> extends AbstractElasticsearchRepository<T, String> {

    private ElasticsearchOperations elasticsearchOperations;

    private Class<T> entityClass;

    private ElasticsearchEntityInformation<T, String> entityInformation;

    public SimpleElasticsearchRepository(ElasticsearchEntityInformation<T, String> entityInformation,
                                        ElasticsearchOperations operations) {
         super();

         this.elasticsearchOperations = elasticsearchOperations;
         this.entityInformation = entityInformation;
    }

    

    @Override
    public <S extends T> S save(S entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public <S extends T> Iterable<S> save(Iterable<S> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public T findOne(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findOne'");
    }

    @Override
    public boolean exists(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public Iterable<T> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Iterable<T> findAll(Iterable<String> ids) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void delete(T entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void delete(Iterable<? extends T> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void deleteAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteAll'");
    }



    @Override
    protected String stringIdRepresentation(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'stringIdRepresentation'");
    }
    


}
