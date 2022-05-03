package com.upload_file_aws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.upload_file_aws.model.File;
import com.upload_file_aws.serviceImpl.FileServiceImpl;

@RestController
@RequestMapping("/file")
public class UploadContrller {
	
	@Autowired
	private FileServiceImpl disc;

	@PostMapping(value = "/upload")
	public void upload(@RequestParam MultipartFile file) {
		disc.saveFile(file);
	}	
	
	@GetMapping
	public List<File> getFile() {
		return disc.getFile();
	}
	
	@DeleteMapping({ "/{id}" })
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteFile(@PathVariable String id) {
		disc.deleteFile(id);
	}
}