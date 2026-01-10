package com.project.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService  {
	
	@Value("${file.upload.path}")
	private String uploadPath;
	
	public Boolean uploadFile(MultipartFile file) throws IOException {
		String originalFilename = file.getOriginalFilename();
		File saveDir = new File(uploadPath);
		
		if(!saveDir.exists()) {
			saveDir.mkdirs();
		}		
		String storePath = uploadPath.concat(originalFilename);
		// Construct full file path safely
//        Path filePath = Paths.get(uploadPath, originalFilename);
		
		long copy = Files.copy(file.getInputStream(), Paths.get(storePath));
//		long copy = Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
		if(copy != 0)
			return false;
		
		return true;
	}
	
	
//	 @Value("${file.upload.path}")
//	    private String uploadPath;

//	    public Boolean uploadFile(MultipartFile file) throws IOException {
//	        String originalFilename = file.getOriginalFilename();

	        // Create directory if not exists
//	        File saveDir = new File(uploadPath);
//	        if (!saveDir.exists()) {
//	            saveDir.mkdirs(); // mkdirs() handles nested directories
//	        }

	        // Construct full file path safely
//	        Path filePath = Paths.get(uploadPath, originalFilename);

	        // Save file (overwrite if already exists)
//	        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

//	        return true; // If no exception, upload successful
	
	
	
	
	
}
