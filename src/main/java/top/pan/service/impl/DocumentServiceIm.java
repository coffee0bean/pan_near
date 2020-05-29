package top.pan.service.impl;

import org.springframework.stereotype.Service;
import top.pan.entity.Document;
import top.pan.repository.DocumentRepository;
import top.pan.service.DocumentServiceIn;

import java.util.Optional;

@Service
public class DocumentServiceIm implements DocumentServiceIn {

    private final DocumentRepository documentRepository;

    public DocumentServiceIm(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document save(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document selectDocument(String absolutePath) {
        Optional<Document> optional = documentRepository.findDocumentByAbsolutePath(absolutePath);
        return optional.get();
    }
}
