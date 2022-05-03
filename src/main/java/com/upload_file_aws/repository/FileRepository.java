package com.upload_file_aws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upload_file_aws.model.File;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}