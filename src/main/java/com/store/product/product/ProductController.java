package com.store.product.product;

import com.store.base.BaseMapper;
import com.store.base.BaseRestController;
import com.store.base.BaseService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController extends BaseRestController<Product, ProductDTO> {

    public ProductController(BaseService<Product> service, BaseMapper<Product, ProductDTO> mapper) {
        super(service, mapper);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @Override
    public ResponseEntity<ProductDTO> create(@RequestPart("listing") ProductDTO dto) {
        return super.create(dto);
    }
}
