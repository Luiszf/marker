package com.luis.biscoin.service;

import com.luis.biscoin.imageProcessing.CompressDecompress;
import com.luis.biscoin.model.ImageData;
import com.luis.biscoin.repository.imageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;


@Service
public class ImageDataService {

    @Autowired
    private imageRepository repository;

    public String uploadImage(MultipartFile file) throws IOException {

        ImageData imageData = repository.save(
                ImageData.builder()
                        .name(file.getName())
                        .format(file.getContentType())
                        .fileData(CompressDecompress.compressImage(file.getBytes()))
                        .build());

        return ("Image was successfully stored in the database: " + file.getOriginalFilename());
    }

    public byte[] downloadImage(Long id) {
        Optional<ImageData> databaseImageData = repository.findById(id);
        byte[] images = CompressDecompress.decompressImage(databaseImageData.get().getFileData());
        return images;
    }
}


