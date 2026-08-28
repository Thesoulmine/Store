package com.store.product.product;

import com.store.base.BaseMapper;
import com.store.base.BaseRestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/products")
public class ProductController extends BaseRestController<Product, ProductDTO> {

    private final ProductService productService;

    public ProductController(
            ProductService productService,
            BaseMapper<Product, ProductDTO> mapper) {
        super(productService, mapper);
        this.productService = productService;
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<ProductDTO> create(@RequestPart("listing") SaveProductDTO dto) {
        return new ResponseEntity<>(mapper.toDto(productService.create(dto)), HttpStatus.OK);
    }
}
