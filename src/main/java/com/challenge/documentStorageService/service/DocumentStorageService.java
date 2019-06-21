package com.challenge.documentStorageService.service;

import com.challenge.documentStorageService.model.Document;
import com.challenge.documentStorageService.repository.DocumentStorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DocumentStorageService {

    private final DocumentStorageRepository documentStorageRepository;

    @Autowired
    public DocumentStorageService(final DocumentStorageRepository documentStorageRepository) {
        this.documentStorageRepository = documentStorageRepository;
    }

    public String saveDocumentDetails(final String documentContent) {
        /*final Document document = documentStorageRepository.save(new Document().withDocumentContents(documentContent));
        return document.getDocumentId();*/
        return documentStorageRepository.save(new Document().withDocumentContents(documentContent)).getDocumentId();
    }

    public String getDocumentDetails(String docId) {
        final Optional<Document> document = documentStorageRepository.findById(docId);
        return document.isPresent() ? document.get().getDocumentContents() : null;
        //return documentStorageRepository.findById(docId);
    }
}
