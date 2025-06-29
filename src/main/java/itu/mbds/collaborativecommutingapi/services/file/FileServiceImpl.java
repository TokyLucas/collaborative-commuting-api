package itu.mbds.collaborativecommutingapi.services.file;

import itu.mbds.collaborativecommutingapi.helpers.StringHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Service
public class FileServiceImpl implements IFileService {
    @Override
    public String upload(String dir, MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(dir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String fileName = file.getOriginalFilename();
        if (fileName != null) {
            String uuid = UUID.randomUUID().toString();
            fileName = uuid + "-" + StringHelper.clean(fileName);
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
            return filePath.toString();
        }
        return null;
    }

    @Override
    public boolean delete(String fileName) {
        File file = new File(fileName);
        return file.exists() && file.delete();
    }

}