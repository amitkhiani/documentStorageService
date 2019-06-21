package com.challenge.documentStorageService.repository;

import com.challenge.documentStorageService.model.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentStorageRepository extends JpaRepository<Document, String> {

}
