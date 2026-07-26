package com.store.base;

import com.store.product.image.Image;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
public abstract class BaseService<E> {

    protected final BaseJpaRepository<E, Long> dbRepository;

    public List<E> getAll(Pageable pageable) {
        return dbRepository.findAll(pageable).getContent();
    }

    public List<E> getAllByIds(List<Long> ids) {
        return dbRepository.findAllById(ids);
    }

    public E getById(Long id) {
        return dbRepository.findById(id).orElseThrow();
    }

    @Transactional
    public E create(E entity) {
        return dbRepository.save(entity);
    }

    @Transactional
    public void removeById(Long id) {
        dbRepository.deleteById(id);
    }

    @Transactional
    public void remove(E entity) {
        dbRepository.delete(entity);
    }
}
