package com.challenge.documentStorageService.controller;

import com.challenge.documentStorageService.model.CreateDocumentResponse;
import com.challenge.documentStorageService.service.DocumentStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController()
@RequestMapping("/storage")
public class DocumentStorage {

    private DocumentStorageService documentStorageService;

    @Autowired
    public DocumentStorage(final DocumentStorageService documentStorageService) {
        this.documentStorageService = documentStorageService;
    }

    //Create - POST /storage/documents
    @PostMapping(value = "/documents", produces = "text/plain")
    @ResponseStatus(HttpStatus.CREATED)
    public CreateDocumentResponse createDocumentForStorage(@RequestBody String documentContent) {
        return new CreateDocumentResponse().withDocumentId(documentStorageService.saveDocumentDetails(documentContent));
    }

    //Query - GET /storage/documents/{docId}
    @GetMapping(value = "/documents/{docId}", produces = "text/plain")
    @ResponseStatus(HttpStatus.OK)
    public String getDocument(@PathVariable String docId) throws Exception {
        System.out.println("Get document..." + docId);
        final String documentContents = documentStorageService.getDocumentDetails(docId);
        if (documentContents == null) {
            throw new Exception("Document Id not found.");
        }
        return documentContents;
    }

    //Update - PUT /storage/documents/{docId}
    @PutMapping("/documents/{docId}")
    public CreateDocumentResponse updateStoredDocument(@PathVariable String docId) {
        return null;
    }

    //Delete - DELETE /storage/documents/{docId}
    @DeleteMapping("/documents/{docId}")
    public CreateDocumentResponse deleteStoredDocument(@PathVariable String docId) {
        return null;
    }
}