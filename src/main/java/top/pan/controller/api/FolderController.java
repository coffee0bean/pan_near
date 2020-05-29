package top.pan.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import top.pan.entity.Folder;
import top.pan.local.FolderLocalUtil;
import top.pan.service.DocumentServiceIn;
import top.pan.service.FolderServiceIn;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @Author coffee0bean
 * @Description
 * @Date 14:45 2020/5/27
 */
@RestController
@RequestMapping("api/folder")
public class FolderController extends BaseController {
    public FolderController(FolderServiceIn folderServiceIn, DocumentServiceIn documentServiceIn) {
        super(folderServiceIn, documentServiceIn);
    }

    /**
     *
     * @param currentPath
     * @param folderName
     * @return
     */
    @RequestMapping("new.folder")
    public@ResponseBody
    String mkdirFolder(String currentPath, String folderName){
        File file = FolderLocalUtil.mkdirFolder(rootPath + "\\" + currentPath.replace("/","\\"),folderName);
        System.out.println(rootPath + "\\" + currentPath.replace("/","\\"));
        Folder folder = null;
        if(file.exists()){
            folder = new Folder();
            folder.setFolderName(file.getName());
            folder.setAbsolutePath(file.getAbsolutePath());
            folder.setCreateDate(new Date());
            folder.setIsDir(true);
            folder.setLastModify(new Date(file.lastModified()));
            folderServiceIn.save(folder);
            super.updatedInRealTime();
            return "true";
        }
        return "false";
    }


}
