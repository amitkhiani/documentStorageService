package com.challenge.documentStorageService.controller;

import com.challenge.documentStorageService.model.CreateDocumentResponse;
import com.challenge.documentStorageService.service.DocumentStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        // TODO: Change the null logic to service class.
        final String documentContents = documentStorageService.getDocumentDetails(docId);
        if (documentContents == null) {
            // TODO: Change to custom exception.
            throw new Exception("Document Id not found.");
        }
        return documentContents;
    }

    //Update - PUT /storage/documents/{docId}
    @PutMapping("/documents/{docId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStoredDocument(@PathVariable String docId, @RequestBody String updatedDocumentContent) throws Exception {
        System.out.println("Update the document..." + docId);
        System.out.println("Update the document..." + updatedDocumentContent);
        // Check for document exists or not.
        // TODO: Change the null logic to service class.
        final String documentContents = documentStorageService.getDocumentDetails(docId);
        if (documentContents == null) {
            // TODO: Change to custom exception.
            throw new Exception("Document Id not found.");
        }
        // Update the document content.
        documentStorageService.updateStoredDocument(docId, updatedDocumentContent);
    }

    //Delete - DELETE /storage/documents/{docId}
    @DeleteMapping("/documents/{docId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStoredDocument(@PathVariable String docId) throws Exception{
        System.out.println("Delete the document..." + docId);
        // Check for document exists or not.
        // TODO: Change the null logic to service class.
        final String documentContents = documentStorageService.getDocumentDetails(docId);
        if (documentContents == null) {
            // TODO: Change to custom exception.
            throw new Exception("Document Id not found.");
        }
        // Delete the document.
        documentStorageService.deleteStoredDocumentDetails(docId);
    }
}