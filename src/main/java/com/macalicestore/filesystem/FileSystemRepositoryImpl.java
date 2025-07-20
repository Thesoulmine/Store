package com.macalicestore.filesystem;

import jakarta.annotation.Nonnull;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

@Repository
public class FileSystemRepositoryImpl implements FileSystemRepository {

    private final static Path FILES_DIRECTORY_PATH = Paths.get(System.getProperty("user.dir"), "files");

    @PostConstruct
    public void init() {
        createDirectory(Paths.get(""));
    }

    @Override
    public Resource findFileByPath(Path filePath) {
        try {
            return new UrlResource(FILES_DIRECTORY_PATH.resolve(filePath).toUri());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveFile(String directoryPath, String fileName, MultipartFile file) {
        Path directory = FILES_DIRECTORY_PATH.resolve(directoryPath);
        createDirectories(directory);
        Path uploadFile = directory.resolve(fileName);
        try {
            file.transferTo(uploadFile);
        } catch (IOException e) {

        }
    }

    @Override
    public boolean deleteFile(Path filePath) {
        return FILES_DIRECTORY_PATH.resolve(filePath).toFile().delete();
    }

    @Override
    public void createDirectory(Path directoryPath) {
        try {
            Files.createDirectory(FILES_DIRECTORY_PATH.resolve(directoryPath));
        } catch (IOException e) {

        }
    }

    @Override
    public void createDirectories(Path directoriesPath) {
        try {
            Files.createDirectories(FILES_DIRECTORY_PATH.resolve(directoriesPath));
        } catch (IOException e) {

        }
    }

    @Override
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

        }
    }
}
