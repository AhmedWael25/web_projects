package com.playground.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/upload.htm")
public class FileUpload {

    @GetMapping
    public String showPage(){
        return "upload";
    }


    @PostMapping
    @ResponseBody
    public String uploadFileHandler(@RequestParam("file") MultipartFile file){
         
        if(!file.isEmpty()){

            return "File Uploaded of name:" + file.getOriginalFilename() + " : , And size =" + file.getSize();
        }else{
            return "File Upload Failed";
        }
    }
    
}
