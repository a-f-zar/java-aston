package com.aston.proxy.service.impl;

import com.aston.proxy.domain.model.Document;
import com.aston.proxy.domain.model.User;
import com.aston.proxy.service.DocumentService;

public class RealDocumentService implements DocumentService {

    @Override
    public void openDocument(User user, Document document) {
        System.out.println("Пользователь " + user.getName() + " открыл документ: " + document.getTitle());
        System.out.println("Содержимое документа: " + document.getContent());
    }
}