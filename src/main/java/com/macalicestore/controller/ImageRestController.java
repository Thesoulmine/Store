package com.macalicestore.controller;

import com.macalicestore.entity.Image;
import com.macalicestore.service.ImageService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("")
public class ImageRestController {

    private final ImageService imageService;

    public ImageRestController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/api/listings/images")
    public ResponseEntity<List<Image>> getAllImages() {
        return new ResponseEntity<>(imageService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/api/listings/images/{id}")
    public ResponseEntity<Image> getImage(@PathVariable("id") Long id) {
        return new ResponseEntity<>(imageService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/uploads/images/{filename}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadImage(@PathVariable("filename") String filename) throws IOException {
        return new ResponseEntity<>(imageService.downloadImage(filename), HttpStatus.OK);
    }
}
