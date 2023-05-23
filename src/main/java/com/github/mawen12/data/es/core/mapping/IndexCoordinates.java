package com.github.mawen12.data.es.core.mapping;

import java.util.Objects;

import lombok.Data;

@Data
public class IndexCoordinates {
   
    public static final String TYPE = "_doc";

    private final String[] indexNames;

    public static IndexCoordinates of(String... indexNames) {
        Objects.requireNonNull(indexNames, () -> "indexNames must not be null");
        return new IndexCoordinates();
    }

    public IndexCoordinates(String... indexNames) {
        this.indexNames = indexNames;
    }

    public String getIndexName() {
        return indexNames[0];
    }
}
