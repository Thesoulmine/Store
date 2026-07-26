package com.store.product.product;

import com.store.base.BaseJpaRepository;
import com.store.base.BaseService;
import com.store.product.image.Image;
import com.store.product.image.ImageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService extends BaseService<Product> {

    private final ProductMapper mapper;
    private final ImageService imageService;

    public ProductService(
            BaseJpaRepository<Product, Long> dbRepository,
            ProductMapper mapper,
            ImageService imageService) {
        super(dbRepository);
        this.mapper = mapper;
        this.imageService = imageService;
    }

    public Product create(SaveProductDTO dto) {
        Product product = mapper.toEntity(dto);
        List<Image> images = new ArrayList<>();
        List<Long> existImageIds = new ArrayList<>();
        dto.getImages().forEach(image -> {
            switch (image) {
                case SaveProductDTO.NewImageDTO newImg -> images
                        .add(imageService.create(newImg.getImage(), String.valueOf(product.getId())));
                case SaveProductDTO.ExistImageDTO existImg -> existImageIds.add(existImg.getId());
                default -> throw new IllegalArgumentException("Unknown image type");
            }
        });
        images.addAll(imageService.getAllByIds(existImageIds));
        product.setImages(images);
        return super.create(product);
    }
}
