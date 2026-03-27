package com.aston.proxy;

import com.aston.proxy.client.DocumentViewer;
import com.aston.proxy.domain.enums.UserRole;
import com.aston.proxy.domain.model.Document;
import com.aston.proxy.domain.model.User;
import com.aston.proxy.service.DocumentService;
import com.aston.proxy.service.impl.DocumentServiceProxy;
import com.aston.proxy.service.impl.RealDocumentService;

public class ProxyDemo {

    public static void main(String[] args) {
        Document publicDocument = new Document("Инструкция", "Обычная инструкция для всех пользователей", false);

        Document restrictedDocument = new Document("Финансовый отчет", "Конфиденциальные данные компании", true);

        User admin = new User("Airat", UserRole.ADMIN);
        User user = new User("Иван", UserRole.USER);
        User guest = new User("Гость", UserRole.GUEST);

        DocumentService realDocumentService = new RealDocumentService();
        DocumentService proxyDocumentService = new DocumentServiceProxy(realDocumentService);

        DocumentViewer viewer = new DocumentViewer(proxyDocumentService);

        viewer.viewDocument(user, publicDocument);
        System.out.println();

        viewer.viewDocument(guest, publicDocument);
        System.out.println();

        viewer.viewDocument(admin, restrictedDocument);
        System.out.println();

        viewer.viewDocument(user, restrictedDocument);
    }
}