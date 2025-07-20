package com.macalicestore.listing.image;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("")
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/api/listings/images")
    public ResponseEntity<List<Image>> getAllImages() {
        return new ResponseEntity<>(imageService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/api/listings/images/{id}")
    public ResponseEntity<Image> getImage(@PathVariable("id") Long id) {
        return new ResponseEntity<>(imageService.getById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/uploads/images/{id}/{filename}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getImageResource(@PathVariable("id") String id,
                                                     @PathVariable("filename") String filename) throws IOException {
        return new ResponseEntity<>(imageService.getAsResource(filename, id), HttpStatus.OK);
    }
}
