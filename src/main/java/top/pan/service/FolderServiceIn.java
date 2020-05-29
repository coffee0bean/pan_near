package top.pan.service;

import top.pan.entity.Folder;

import java.util.List;

public interface FolderServiceIn {

    public Folder save(Folder folder);

    public Folder selectFolder(String absolutePath);
}
