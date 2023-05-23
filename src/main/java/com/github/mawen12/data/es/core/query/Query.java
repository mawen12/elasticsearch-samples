package com.github.mawen12.data.es.core.query;

import java.util.List;

public interface Query {
    
    public static final int DEFAULT_PAGE_SIZE = 10;

    List<String> getIndices();

    void addIndices(String... indices);

    List<String> getTypes();

    void addTypes(String... types);

    List<String> getFields();

    void addFields(String... fields);

}
