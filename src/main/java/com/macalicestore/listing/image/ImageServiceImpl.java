package com.macalicestore.listing.image;

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
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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

    @Transactional
    @Override
    public Image saveImageInDirectory(MultipartFile file, String directoryName) throws IOException {
        Image image = new Image();
        image.setUploadDate(LocalDateTime.now());
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setUrl(MessageFormat.format("localhost:8080/uploads/images/{0}/{1}", directoryName, image.getName()));
        image = imageRepository.save(image);
        file.transferTo(Paths.get("src/main/resources/static/images", directoryName, image.getName()));
        return image;
    }

    //TODO сделать saveImages butch
    @Override
    public Resource findFileByFilenameInDirectoryAndConvertToResource(
            String fileName,
            String directoryName) throws MalformedURLException {
        Path file = Paths.get("src/main/resources/static/images", directoryName, fileName);
        return new UrlResource(file.toUri());
    }


    // TODO рефактор
    @Transactional
    @Override
    public List<Image> findOrCreateImagesInDirectory(MultipartFile[] images,
                                                     String directoryName) throws IOException {
        List<Image> existedImages = imageRepository.findImagesByNameIn(
                Arrays.stream(images)
                        .map(MultipartFile::getOriginalFilename)
                        .toList());
        Map<String, Image> nameImageMap = existedImages.stream()
                .collect(Collectors.toMap(Image::getName, image -> image));
        List<Image> returnList = new ArrayList<>();

        for (MultipartFile file : images) {
            if (nameImageMap.get(file.getOriginalFilename()) == null) {
                returnList.add(saveImageInDirectory(file, directoryName));
            } else {
                returnList.add(nameImageMap.get(file.getOriginalFilename()));
            }
        }
        return returnList;
    }

    @Override
    public void createDirectoryIfNotExist(String directoryName) throws IOException {
        Path directory = Paths.get("src/main/resources/static/images").resolve(directoryName);

        if (!Files.exists(directory)) {
            Files.createDirectory(directory);
        }
    }
}
