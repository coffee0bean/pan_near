package top.pan.service;


import top.pan.entity.Document;

public interface DocumentServiceIn {
    public Document save(Document document);

    public Document selectDocument(String absolutePath);
}
