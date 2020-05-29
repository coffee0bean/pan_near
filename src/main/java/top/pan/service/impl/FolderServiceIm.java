package top.pan.service.impl;

import org.springframework.stereotype.Service;
import top.pan.entity.Folder;
import top.pan.repository.FolderRepository;
import top.pan.service.FolderServiceIn;

import java.util.Optional;

@Service
public class FolderServiceIm implements FolderServiceIn {

    private final FolderRepository folderRepository;

    public FolderServiceIm(FolderRepository folderRepository) {
        this.folderRepository = folderRepository;
    }

    @Override
    public Folder save(Folder folder){
        return folderRepository.save(folder);
    }

    @Override
    public Folder selectFolder(String absolutePath) {
        Optional<Folder> optionalFolder = folderRepository.findAllByAbsolutePath(absolutePath);
        return optionalFolder.get();
    }
}
