package com.store.base;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping("/api")
public abstract class BaseRestController<E, D> {

    protected final BaseService<E> service;
    protected final BaseMapper<E, D> mapper;

    @GetMapping()
    public ResponseEntity<List<D>> getAll(
            @RequestParam(value = "page", defaultValue = "0") @Min(0) Integer page,
            @RequestParam(value = "limit", defaultValue = "20") @Min(1) @Max(100) Integer limit,
            @RequestParam("order") Sort.Direction order) {
        return new ResponseEntity<>(mapper.toDto(service.getAll(PageRequest.of(page, limit, order))), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable Long id) {
        return new ResponseEntity<>(mapper.toDto(service.getById(id)), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<D> create(@RequestBody D dto) {
        return new ResponseEntity<>(mapper.toDto(service.create(mapper.toEntity(dto))), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeById(@PathVariable Long id) {
        service.removeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
