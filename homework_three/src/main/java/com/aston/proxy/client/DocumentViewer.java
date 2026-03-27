package com.aston.proxy.client;

import com.aston.proxy.domain.model.Document;
import com.aston.proxy.domain.model.User;
import com.aston.proxy.service.DocumentService;

public class DocumentViewer {

    private final DocumentService documentService;

    public DocumentViewer(DocumentService documentService) {
        this.documentService = documentService;
    }

    public void viewDocument(User user, Document document) {
        documentService.openDocument(user, document);
    }
}