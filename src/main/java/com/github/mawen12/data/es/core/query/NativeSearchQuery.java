package com.github.mawen12.data.es.core.query;

import org.elasticsearch.index.query.QueryBuilder;

public class NativeSearchQuery extends AbstractQuery implements SearchQuery {

    private QueryBuilder query;

    public NativeSearchQuery(QueryBuilder query) {
        this.query = query;
    }

    @Override
    public QueryBuilder getQuery() {
        return query;
    }
    
    
}
