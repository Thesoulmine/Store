package com.macalicestore.listing.image;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface ImageService {

    List<Image> findAll();

    Image findById(Long id);

    Image saveImageInDirectory(MultipartFile file, String directoryName) throws IOException;

    Resource findFileByFilenameInDirectoryAndConvertToResource(String filename, String directoryName) throws MalformedURLException;

    List<Image> findOrCreateImagesInDirectory(MultipartFile[] images, String directoryName) throws IOException;

    void createDirectoryIfNotExist(String directoryName) throws IOException;
}
