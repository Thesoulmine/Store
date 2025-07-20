package com.macalicestore.filesystem;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Path;

public interface FileSystemRepository {

    Resource findFileByPath(Path filePath);

    void saveFile(String directoryPath, String fileName, MultipartFile file);

    boolean deleteFile(Path filePath);

    void createDirectory(Path directoryPath);

    void createDirectories(Path directoriesPath);

    void deleteDirectory(Path directoryPath);
}
