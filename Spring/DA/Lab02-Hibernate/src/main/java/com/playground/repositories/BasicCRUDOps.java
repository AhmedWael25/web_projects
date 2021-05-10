package com.playground.repositories;

import java.util.Optional;

public interface BasicCRUDOps<T, ID> {

    <S extends  T> S save (S entity);

    <S extends  T> S update (S entity);

    Optional<T> findById(ID key);

    Iterable<T> findAll();

    long count();

    void deleteById(ID key);

    boolean existById(ID key);
}
