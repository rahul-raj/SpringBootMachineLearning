package com.example.demo.service;

import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class StorageServiceImpl implements StorageService{

    private final Path rootLocation = Paths.get(ClassLoader.getSystemResource("static").toURI());

    private StorageServiceImpl() throws URISyntaxException {
    }

    @Override
    public void init() {

    }

    @Override
    public void store(MultipartFile file) {
        try{
            Files.copy(file.getInputStream(),this.rootLocation.resolve(file.getOriginalFilename()));
        }
        catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
