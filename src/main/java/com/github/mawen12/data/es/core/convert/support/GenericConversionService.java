package com.github.mawen12.data.es.core.convert.support;

import com.github.mawen12.data.es.core.convert.ConversionService;

public class GenericConversionService implements ConversionService{

    @Override
    public boolean canConvert(Class<?> sourceType, Class<?> targetType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'canConvert'");
    }

    @Override
    public <T> T convert(Object source, Class<T> targetType) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convert'");
    }



}
