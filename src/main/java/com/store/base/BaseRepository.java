package com.store.base;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BaseRepository<E, ID> {

    Page<E> findAll(Pageable pageable);

    Optional<E> findById(ID id);

    <S extends E> S save(S entity);

    void deleteById(ID id);
}
