package com.project.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.service.FileService;

@RestController
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@PostMapping("/upload")
	public ResponseEntity<?> uploadFile(@RequestParam("multipartFile") MultipartFile multipartFile) throws IOException{
		Boolean uploadFile = fileService.uploadFile(multipartFile);
		if(uploadFile) {
			return new ResponseEntity<>("Upload Successfully", HttpStatus.CREATED);
		}

		return new ResponseEntity<>("Upload Failed", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	@PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
//	    Boolean uploaded = fileService.uploadFile(file);
//	    return uploaded ? ResponseEntity.ok("Upload Successfully") 
//	                    : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Upload Failed");
//	}


}
