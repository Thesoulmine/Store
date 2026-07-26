package com.store.base.file;

import com.store.base.BaseJpaRepository;
import com.store.base.BaseService;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class FileService<E extends File> extends BaseService<E> {

    private final FileSystemRepository fileSystemRepository;

    public FileService(
            BaseJpaRepository<E, Long> dbRepository,
            FileSystemRepository fileSystemRepository) {
        super(dbRepository);
        this.fileSystemRepository = fileSystemRepository;
    }

    @PostConstruct
    public void init() {
        fileSystemRepository.createDirectory(getDirectory());
    }

    @Transactional
    public E create(MultipartFile multipartFile, String directoryName) {
        E file = getDefaultFile();
        file.setName(multipartFile.getOriginalFilename());
        file.setType(multipartFile.getContentType());
        file.setUrl(getDirectory().resolve(directoryName).resolve(file.getName()).toString());
        file = super.create(file);
        fileSystemRepository.saveFile(getDirectory().resolve(directoryName), file.getName(), multipartFile);
        return file;
    }

    @Override
    public void remove(E file) {
        super.remove(file);
        fileSystemRepository.deleteFile(getDirectory().resolve(file.getUrl()));
    }

    public Resource getAsResource(String fileName, String directoryName) {
        return new FileSystemResource(fileSystemRepository.findFileByPath(getDirectory().resolve(Paths.get(directoryName, fileName))));
    }

    protected abstract Path getDirectory();

    protected abstract E getDefaultFile();
}
