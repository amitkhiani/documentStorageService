package com.challenge.documentStorageService.model;

public class CreateDocumentResponse {

    private String documentId;

    public String getDocumentId() {
        return documentId;
    }

    public CreateDocumentResponse withDocumentId(final String documentId) {
        this.documentId = documentId;
        return this;
    }

    @Override
    public String toString() {
        return "CreateDocumentResponse{" +
                "documentId='" + documentId + '\'' +
                '}';
    }
}
