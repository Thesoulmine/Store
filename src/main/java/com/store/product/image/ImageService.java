package com.store.product.image;

import com.store.base.BaseJpaRepository;
import com.store.base.file.FileService;
import com.store.base.file.FileSystemRepository;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class ImageService extends FileService<Image> {

    public ImageService(
            BaseJpaRepository<Image, Long> dbRepository,
            FileSystemRepository fileSystemRepository) {
        super(dbRepository, fileSystemRepository);
    }

    @Override
    protected Path getDirectory() {
        return Paths.get("images");
    }

    @Override
    protected Image getDefaultFile() {
        return new Image();
    }
}
