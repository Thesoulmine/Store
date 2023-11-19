package com.macalicestore.service;

import com.macalicestore.entity.Image;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface ImageService {

    List<Image> findAll();

    Image findById(Long id);

    Image saveImage(MultipartFile file) throws IOException;

    Resource downloadImage(String filename) throws MalformedURLException;

    void createListingDirectory(String dirName) throws IOException;

    List<Image> findImages(MultipartFile[] files) throws IOException;
}
