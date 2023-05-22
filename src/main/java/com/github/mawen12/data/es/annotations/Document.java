package com.github.mawen12.data.es.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Document {
    
    /**
     * 索引名
     * @return
     */
    String indexName();

    /**
     * 类型
     * @return
     * @deprecated since 7.0
     */
    String type();

    short shards() default 5;

    short replicas() default 1;

    String refreshInterval() default "1s";

    String indexStoreType() default "fs";

    /**
     * 是否创建索引
     * @return
     */
    boolean createIndex() default true;

    /**
     * 是否保存id到source
     * @return
     */
    boolean storeIdInSource() default true;

    /**
     * 是否保存version到source
     * @return
     */
    boolean storeVersionInSource() default true;
}
