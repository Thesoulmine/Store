package com.macalicestore.service;

import com.macalicestore.entity.Image;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ImageService {
    @Transactional
    List<Image> findAll();

    @Transactional
    Image findById(Long id);
}
