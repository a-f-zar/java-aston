package com.aston.proxy.service;

import com.aston.proxy.domain.model.Document;
import com.aston.proxy.domain.model.User;

public interface DocumentService {

    void openDocument(User user, Document document);
}