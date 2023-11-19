package com.macalicestore.service;

import com.macalicestore.entity.Colour;
import com.macalicestore.entity.Image;
import com.macalicestore.repository.ImageRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    //TODO Проработать траназакции и переделать метод под сохранение прямо в нем
    @Transactional
    @Override
    public Image saveImage(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setUploadDate(LocalDateTime.now());
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setUrl("localhost:8081/uploads/images/" + image.getName());
        file.transferTo(Paths.get("src/main/resources/static/images", image.getName()));
        return image;
    }

    @Transactional
    @Override
    public Resource downloadImage(String fileName) throws MalformedURLException {
        Path file = Paths.get("src/main/resources/static/images", fileName);
        return new UrlResource(file.toUri());
    }

    @Override
    public void createListingDirectory(String dirName) throws IOException {
        Path directory = Paths.get("src/main/resources/static/images").resolve(dirName);
        if (!Files.exists(directory)) {
            Files.createDirectory(directory);
        }
    }

    @Transactional
    @Override
    public List<Image> findImages(MultipartFile[] files) throws IOException {
        List<Image> newImagesList = new ArrayList<>();
        for (MultipartFile file : files) {
            newImagesList.add(Objects.requireNonNullElse(
                    imageRepository.findByName(file.getOriginalFilename()),
                    saveImage(file)));
        }
        return newImagesList;
    }
}
