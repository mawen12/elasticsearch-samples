package com.github.mawen12.data.es.core.query;

import lombok.Data;

@Data
public class IndexQuery {
    
    private String id;

    private Object object;

    private Long version;

    private String indexName;

    private String type;

    private String source;
}
