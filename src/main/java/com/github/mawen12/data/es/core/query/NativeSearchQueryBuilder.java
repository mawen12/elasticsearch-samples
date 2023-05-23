package com.github.mawen12.data.es.core.query;

import org.elasticsearch.index.query.QueryBuilder;

public class NativeSearchQueryBuilder {

    private QueryBuilder queryBuilder;

    public NativeSearchQueryBuilder withQuery(QueryBuilder queryBuilder) {
        this.queryBuilder = queryBuilder;
        return this;        
    }

    public NativeSearchQuery build() {
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(queryBuilder);

        return nativeSearchQuery;
    }
}
