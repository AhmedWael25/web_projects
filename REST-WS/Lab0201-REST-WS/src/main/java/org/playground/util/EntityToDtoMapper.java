package org.playground.util;

import java.util.List;
import java.util.stream.Collectors;

public abstract class EntityToDtoMapper<E,T> {

    public abstract  E convertEntityToDto(T entity);
    public   List<E> convertEntityListToDtoList(List<T> entities){
        return entities.stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

}
