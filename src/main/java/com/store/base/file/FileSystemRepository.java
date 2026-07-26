package com.store.base.file;

import jakarta.annotation.Nonnull;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

@Repository
public class FileSystemRepository {

    private final static Path FILES_DIRECTORY_PATH = Paths.get(System.getProperty("user.dir"), "files");

    @PostConstruct
    public void init() {
        createDirectory(Paths.get(""));
    }

    public File findFileByPath(Path filePath) {
        return FILES_DIRECTORY_PATH.resolve(filePath).toFile();
    }

    public void saveFile(Path directoryPath, String fileName, MultipartFile file) {
        try {
            Path directory = FILES_DIRECTORY_PATH.resolve(directoryPath);
            Files.createDirectories(FILES_DIRECTORY_PATH.resolve(directory));
            Path uploadFile = directory.resolve(fileName);
            file.transferTo(uploadFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteFile(Path filePath) {
        FILES_DIRECTORY_PATH.resolve(filePath).toFile().delete();
    }

    public void createDirectory(Path directoryPath) {
        try {
            Files.createDirectory(FILES_DIRECTORY_PATH.resolve(directoryPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteDirectory(Path directoryPath) {
        try {
            Files.walkFileTree(
                    FILES_DIRECTORY_PATH.resolve(directoryPath),
                    new SimpleFileVisitor<>() {
                        @Override
                        public @Nonnull FileVisitResult visitFile(@Nonnull Path file, @Nonnull BasicFileAttributes attrs) throws IOException {
                            Files.delete(file);
                            return FileVisitResult.CONTINUE;
                        }

                        @Override
                        public @Nonnull FileVisitResult postVisitDirectory(@Nonnull Path dir, IOException exc) throws IOException {
                            Files.delete(dir);
                            return FileVisitResult.CONTINUE;
                        }
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
