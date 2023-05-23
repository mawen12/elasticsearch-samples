package com.github.mawen12.data.es.core.convert;

import java.util.Objects;

public interface ElasticsearchConverter {
    
    ConversionService getConversionService();

    default String converteId(Object idValue) {

        Objects.requireNonNull(idValue, () -> "idValue must not be null");

        if (!getConversionService().canConvert(idValue.getClass(), String.class)) {
            return idValue.toString();
        }

        String converted = getConversionService().convert(idValue, String.class);

        if (converted == null) {
            return idValue.toString();
        }

        return converted;
    }
}
