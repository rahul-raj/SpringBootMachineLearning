package com.example.demo.controller;

import com.example.demo.service.DL4JService;
import com.example.demo.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;

@Controller
public class UploadFileController {

    @Autowired
    private DL4JService dl4JService;

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/customerLossDoc/upload")
    public String customerLossPrediction(){
        return "uploadForm";
    }

    @PostMapping("/customerLossDoc/upload")
    public String customerLossPredictionSubmit(Model model, @RequestParam("uploadFile") MultipartFile file){
        try{
              if(file.isEmpty()){
                  model.addAttribute("message","Please select a file and try again!");
                  return "uploadForm";
              }
              String result = dl4JService.fetchPrediction(file);
              log.info(result);
              model.addAttribute("message",result);
        }
        catch(Exception e){
            model.addAttribute("message","Exception");
        }
        return "uploadForm";
    }

}
