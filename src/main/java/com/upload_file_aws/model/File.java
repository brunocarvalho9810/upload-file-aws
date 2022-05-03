package com.upload_file_aws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class File {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String extension;
	private long size;
	private String path;
	
	public File(MultipartFile file, String path) {
		this.name = file.getOriginalFilename();
		this.extension = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		this.size = file.getSize();
		this.path = path;
	}

}