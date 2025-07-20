package com.macalicestore.listing.image;

import com.macalicestore.filesystem.FileSystemRepository;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    private final FileSystemRepository fileSystemRepository;

    private final static Path IMAGES_DIRECTORY_PATH = Paths.get("images");

    public ImageServiceImpl(ImageRepository imageRepository, FileSystemRepository fileSystemRepository) {
        this.imageRepository = imageRepository;
        this.fileSystemRepository = fileSystemRepository;
    }

    @PostConstruct
    public void init() {
        fileSystemRepository.createDirectory(IMAGES_DIRECTORY_PATH);
    }

    @Transactional
    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    @Transactional
    @Override
    public List<Image> getAllById(List<Long> ids) {
        return imageRepository.findAllById(ids);
    }

    @Transactional
    @Override
    public Image getById(Long id) {
        return imageRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Transactional
    @Override
    public Image create(MultipartFile file, String directoryName) {
        Image image = new Image();
        image.setUploadDate(LocalDateTime.now());
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setUrl(IMAGES_DIRECTORY_PATH.resolve(directoryName).resolve(image.getName()).toString());
        image = imageRepository.save(image);
        fileSystemRepository.saveFile(MessageFormat.format("images/{0}", directoryName), image.getName(), file);
        return image;
    }

    @Transactional
    @Override
    public Image delete(Image image) {
        imageRepository.delete(image);
        fileSystemRepository.deleteFile(IMAGES_DIRECTORY_PATH.resolve(image.getUrl()));
        return image;
    }

    @Override
    public Resource getAsResource(String fileName, String directoryName) {
        return fileSystemRepository.findFileByPath(IMAGES_DIRECTORY_PATH.resolve(Paths.get(directoryName, fileName)));
    }
}
