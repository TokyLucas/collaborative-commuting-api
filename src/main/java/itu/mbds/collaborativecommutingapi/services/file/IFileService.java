package itu.mbds.collaborativecommutingapi.services.file;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface IFileService {
    String upload(String dir, MultipartFile file) throws IOException;
    boolean delete(String filename);
}
