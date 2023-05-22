package com.github.mawen12.data.es.core.mapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public interface ElasticsearchPersistentProperty {
    
    // region Persistent
    ElasticsearchPersistentEntity<?> getOwner();

    String getName();

    Class<?> getType();

    Method getGetter();

    Method getSetter();

    Field getField();

    String getSpelExpression();

    boolean isEntity();

    boolean isVersionProperty();

    boolean isCollectionLike();

    boolean isMap();

    boolean isArray();

    boolean isTransient();

    boolean shallBePersisted();

    boolean isAssociation();

    Class<?> getComponentType();

    Class<?> getRawType();

    Class<?> getMapValueType();

    Class<?> getActualType();

    <A extends Annotation> A findAnnotation(Class<A> annotationType);

    <A extends Annotation> A findPropertyOrOwnerAnnotation(Class<A> annotationType);

    boolean isAnnotationPresent(Class<? extends Annotation> annotationType);
    
    boolean usePropertyAccess();
    // endregion

}
