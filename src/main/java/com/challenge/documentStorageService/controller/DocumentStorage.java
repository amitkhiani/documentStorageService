package com.challenge.documentStorageService.controller;

import com.challenge.documentStorageService.exception.DocumentIdNotFoundException;
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
    public String createDocumentForStorage(@RequestBody String documentContent) {
        return documentStorageService.saveDocumentDetails(documentContent);
    }
    /*public CreateDocumentResponse createDocumentForStorage(@RequestBody String documentContent) {
        return new CreateDocumentResponse().withDocumentId(documentStorageService.saveDocumentDetails(documentContent));
    }*/

    //Query - GET /storage/documents/{docId}
    @GetMapping(value = "/documents/{docId}", produces = "text/plain")
    @ResponseStatus(HttpStatus.OK)
    public String getDocument(@PathVariable String docId) {
        // TODO: Change the null logic to service class.
        final String documentContents = documentStorageService.getDocumentDetails(docId);
        if (documentContents == null) {
            throw new DocumentIdNotFoundException("Document Id not found.");
        }
        return documentContents;
    }

    //Update - PUT /storage/documents/{docId}
    @PutMapping("/documents/{docId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStoredDocument(@PathVariable String docId, @RequestBody String updatedDocumentContent) {
        // Check for document exists or not.
        // TODO: Change the null logic to service class.
        final String documentContents = documentStorageService.getDocumentDetails(docId);
        if (documentContents == null) {
            throw new DocumentIdNotFoundException("Document Id not found.");
        }
        // Update the document content.
        documentStorageService.updateStoredDocument(docId, updatedDocumentContent);
    }

    //Delete - DELETE /storage/documents/{docId}
    @DeleteMapping("/documents/{docId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStoredDocument(@PathVariable String docId) {
        // Check for document exists or not.
        // TODO: Change the null logic to service class.
        final String documentContents = documentStorageService.getDocumentDetails(docId);
        if (documentContents == null) {
            throw new DocumentIdNotFoundException("Document Id not found.");
        }
        // Delete the document.
        documentStorageService.deleteStoredDocumentDetails(docId);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(DocumentIdNotFoundException.class)
    public void handleException (DocumentIdNotFoundException exception) {
        // TODO: Write the logic.
    }
}