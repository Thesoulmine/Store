package com.macalicestore.listing.image;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {

    List<Image> getAll();

    List<Image> getAllById(List<Long> ids);

    Image getById(Long id);

    Image create(MultipartFile file, String directoryName);

    Image delete(Image image);

    Resource getAsResource(String filename, String directoryName);

}
