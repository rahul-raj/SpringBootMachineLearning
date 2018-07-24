package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface DL4JService {
    public String fetchPrediction(MultipartFile file) throws IOException, InterruptedException;
}
