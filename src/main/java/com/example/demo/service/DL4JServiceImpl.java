package com.example.demo.service;


import examples.CustomerLossPrediction;


import org.nd4j.linalg.api.ndarray.INDArray;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class DL4JServiceImpl implements DL4JService {
    @Override
    public String fetchPrediction(MultipartFile file) throws IOException, InterruptedException {
        File convFile = new File( file.getOriginalFilename());
        file.transferTo(convFile);
        INDArray array = new CustomerLossPrediction().generateOutput(convFile);
        return array.toString();
    }
}
