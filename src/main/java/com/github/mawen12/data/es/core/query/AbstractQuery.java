package com.github.mawen12.data.es.core.query;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class AbstractQuery implements Query {

    protected List<String> indices = new ArrayList<>();

    protected List<String> types = new ArrayList<>();

    protected List<String> fields = new ArrayList<>();

    protected Collection<String> ids;

    public Collection<String> getIds() {
        return ids;
    }

    public void setIds(Collection<String> ids) {
        this.ids = ids;
    }

    @Override
    public List<String> getIndices() {
        return indices;
    }

    @Override
    public void addIndices(String... indices) {
        Collections.addAll(this.indices, indices);
    }

    @Override
    public List<String> getTypes() {
        return types;
    }

    @Override
    public void addTypes(String... types) {
        Collections.addAll(this.types, types);
    }
    
    @Override
    public List<String> getFields() {
        return fields;
    }

    @Override
    public void addFields(String... fields) {
        Collections.addAll(this.fields, fields);
    }
}
