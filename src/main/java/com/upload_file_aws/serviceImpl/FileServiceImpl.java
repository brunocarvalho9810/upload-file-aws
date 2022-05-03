package com.upload_file_aws.serviceImpl;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.upload_file_aws.model.File;
import com.upload_file_aws.repository.FileRepository;
import com.upload_file_aws.service.FileService;

@Service
public class FileServiceImpl implements FileService{

	@Value("${disc.raiz}")
	private String raiz;
	
	@Value("${disc.directory-file}")
	private String directoryFile;
	
	@Autowired
	private FileRepository repository;

	@Override
	public void saveFile(MultipartFile file) {
		
		Path directoryPath = Paths.get(this.raiz, directoryFile);
		Path arquivoPath = directoryPath.resolve(file.getOriginalFilename());
		
		try {
			Files.createDirectories(directoryPath);
			file.transferTo(arquivoPath.toFile());
			saveFileRDS(file, arquivoPath.toString());
		} catch (Exception e) {
			throw new RuntimeException("Problemas na tentativa de salvar o arquivo", e.getCause());
		}
	}
	
	private void saveFileRDS(MultipartFile file, String path) {
		
		File fileSave = new File(file, path);
		repository.save(fileSave);

	}

	@Override
	public List<File> getFile() {
		return repository.findAll();
	}

	@Override
	public void deleteFile(String id) {
		try {
			repository.deleteById(Long.valueOf(id));
		} catch (Exception e) {
			throw new RuntimeException("Problemas na tentativa de deletar o arquivo", e.getCause());
		}
	}
}






