package com.github.mawen12.data.es.core.query;

import org.elasticsearch.index.query.QueryBuilder;

public interface SearchQuery extends Query{
    
    QueryBuilder getQuery();

}
