package com.github.mawen12.data.es.core;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.github.mawen12.data.es.core.mapping.IndexCoordinates;
import com.github.mawen12.data.es.core.query.GetQuery;
import com.github.mawen12.data.es.core.query.IndexQuery;
import com.github.mawen12.data.es.core.query.Query;
import com.github.mawen12.data.es.core.query.SearchQuery;
import com.github.mawen12.data.es.core.support.AbstractElasticsearchTemplate;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.DeleteResponse;
import co.elastic.clients.elasticsearch.core.GetResponse;
import co.elastic.clients.elasticsearch.core.IndexResponse;

public class ElasticsearchTemplate extends AbstractElasticsearchTemplate {

    private ElasticsearchClient client;

    public ElasticsearchTemplate(ElasticsearchClient client) {
        Objects.requireNonNull(client, () -> "Client must not be null");
        this.client = client;
    }

    @Override
    public <T> Iterable<T> save(Iterable<T> entities) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public <T> List<T> list(Query query, Class<T> clazz) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'list'");
    }

    @Override
    public boolean exists(String id, Class<?> clazz) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exists'");
    }

    @Override
    public String delete(Object entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public <T> T queryForObject(GetQuery query, Class<T> clazz) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'queryForObject'");
    }

    @Override
    public <T> long count(SearchQuery query, Class<T> clazz) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    public <T> long count(SearchQuery query) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'count'");
    }

    @Override
    protected <T> T save(T entity, IndexCoordinates indexCoordinates) {
        String indexName = indexCoordinates.getIndexName();

        try {
            IndexResponse response = client.index(i -> i.index(indexName).document(entity));
        } catch (ElasticsearchException | IOException e) {
            e.printStackTrace();
        }
        
        return entity;
    }

    @Override
    protected <T> T get(String id, Class<T> clazz, IndexCoordinates indexCoordinates) {
        String indexName = indexCoordinates.getIndexName();
        try {
            GetResponse response = client.get(g -> g.index(indexName).id(id), clazz);
            return (T) response.source();
        } catch (ElasticsearchException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected String delete(String id, Class<?> entityType, IndexCoordinates indexCoordinates) {
        String indexName = indexCoordinates.getIndexName();
        try {
            DeleteResponse response = client.delete(d -> d.index(indexName).id(id));
            return response.result().jsonValue();
        } catch (ElasticsearchException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
