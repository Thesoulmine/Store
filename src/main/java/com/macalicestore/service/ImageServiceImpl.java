package com.macalicestore.service;

import com.macalicestore.entity.Image;
import com.macalicestore.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Transactional
    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Transactional
    @Override
    public Image findById(Long id) {
        return imageRepository.findById(id).get();
    }
}
