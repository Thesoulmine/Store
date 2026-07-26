package com.store.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface BaseJpaRepository<E, ID> extends JpaRepository<E, ID>, BaseRepository<E, ID> {
}
