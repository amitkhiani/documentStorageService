package com.challenge.documentStorageService.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Document {

    @Id
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    private String documentId;

    @Column(name = "name", columnDefinition = "VARCHAR(255)")
    private String documentName;

    @Column(name = "size", columnDefinition = "NUMBER(20)")
    private long documentSize;

    @Column(name = "contents", columnDefinition = "VARCHAR(2048)")
    private String documentContents;

    public String getDocumentId() {
        return documentId;
    }

    public String getDocumentName() {
        return documentName;
    }

    public long getDocumentSize() {
        return documentSize;
    }

    public String getDocumentContents() {
        return documentContents;
    }

    public Document withDocumentId(final String documentId) {
        this.documentId = documentId;
        return this;
    }

    public Document withDocumentName(final String documentName) {
        this.documentName = documentName;
        return this;
    }

    public Document withDocumentSize(final long documentSize) {
        this.documentSize = documentSize;
        return this;
    }

    public Document withDocumentContents(final String documentContents) {
        this.documentContents = documentContents;
        return this;
    }

    @Override
    public String toString() {
        return "Document{" +
                "documentId='" + documentId + '\'' +
                ", documentName='" + documentName + '\'' +
                ", documentSize=" + documentSize +
                ", documentContents='" + documentContents + '\'' +
                '}';
    }
}
