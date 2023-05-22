package com.github.mawen12.data.es.core.mapping;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import lombok.Getter;

@Getter
public class SimpleElasticsearchPersistentProperty {
    
    private static final Set<Class<?>> SUPPORTED_ID_TYPES = new HashSet<>();

    private static final Set<String> SUPPORTED_ID_PROPERTY_NAMES = new HashSet<>();

    static {
        SUPPORTED_ID_TYPES.add(String.class);

        SUPPORTED_ID_PROPERTY_NAMES.add("id");
        SUPPORTED_ID_PROPERTY_NAMES.add("documentId");
    }

    private final String name;

    private final PropertyDescriptor propertyDescriptor;

    private final Class<?> rawType;

    private final Field field;

    private final SimpleElasticsearchPersistentEntity owner;

    private Boolean isTransient;

    public SimpleElasticsearchPersistentProperty(Field field, PropertyDescriptor propertyDescriptor, SimpleElasticsearchPersistentEntity owner) {
        Objects.requireNonNull(owner);
        
        this.name = field == null ? propertyDescriptor.getName() : field.getName();
        this.rawType = field == null ? propertyDescriptor.getPropertyType() : field.getType();
        this.propertyDescriptor = propertyDescriptor;
        this.field = field;
        this.owner = owner;
    }

    public boolean isIdProperty() {
        return field != null && SUPPORTED_ID_PROPERTY_NAMES.contains(getName());
    }
}
