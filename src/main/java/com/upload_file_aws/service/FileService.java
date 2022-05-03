package com.upload_file_aws.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.upload_file_aws.model.File;

public interface FileService {

	public void saveFile(MultipartFile file);
	public List<File> getFile();
	public void deleteFile(String id);
}
