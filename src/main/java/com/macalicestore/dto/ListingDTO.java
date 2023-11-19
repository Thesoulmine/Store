package com.macalicestore.dto;

import com.macalicestore.entity.Category;
import com.macalicestore.entity.Colour;
import com.macalicestore.entity.Image;
import com.macalicestore.entity.Listing;
import jakarta.persistence.Column;
import lombok.Data;
import org.mapstruct.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@Mapper
public class ListingDTO {

    private Long id;

    private String title;

    @Column(length = 65535)
    private String description;

    private String material;

    private Integer price;

    private List<Colour> colours;

    private List<Image> images;

    private Category category;
}