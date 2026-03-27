package com.aston.proxy.service.impl;

import com.aston.proxy.domain.enums.UserRole;
import com.aston.proxy.domain.model.Document;
import com.aston.proxy.domain.model.User;
import com.aston.proxy.service.DocumentService;

public class DocumentServiceProxy implements DocumentService {

    private final DocumentService documentService;

    public DocumentServiceProxy(DocumentService documentService) {
        this.documentService = documentService;
    }

    @Override
    public void openDocument(User user, Document document) {
        if (document.isRestricted() && user.getRole() != UserRole.ADMIN) {
            System.out.println("Доступ запрещен. Пользователь " + user.getName() + " не может открыть документ: " + document.getTitle());
            return;
        }

        documentService.openDocument(user, document);
    }
}