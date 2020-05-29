package top.pan.controller.api;
/**
 * @Author coffee0bean
 * @Description
 * @Date 15:30 2020/5/25
 */
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pan.entity.Document;
import top.pan.entity.Folder;
import top.pan.local.FolderLocalUtil;
import top.pan.service.DocumentServiceIn;
import top.pan.service.FolderServiceIn;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class BaseController  {

    @Value("${root.path}")
    protected String rootPath;

    protected final FolderServiceIn folderServiceIn;
    protected final DocumentServiceIn documentServiceIn;


    public BaseController(FolderServiceIn folderServiceIn, DocumentServiceIn documentServiceIn) {
        this.folderServiceIn = folderServiceIn;
        this.documentServiceIn = documentServiceIn;
    }

    /**
     * Load and scan all existing files
     * The scan is divided into local scan and database scan and comparison return information to generate the object return
     * @return The Java class object list
     */
    @RequestMapping("loading")
    public List<Map> loading(){
        List<Map> folders = new ArrayList<>();
        Folder folder = null;
        //Local folder scan
        /**
         * Consider encapsulating a method to combine local file objects with database file objects
         */
        try{
            for(File file : FolderLocalUtil.scannerFile(rootPath)){                 //Loop to the absolute path of the local folder to find the
                folder = folderServiceIn.selectFolder(file.getAbsolutePath());      //folder in the database corresponding to the information
                folders.add(folder.toJson());
            }
        }catch (Exception e){
            return null;
        }
        this.updatedInRealTime();
        return folders;
    }


    /**
     * The request to update the file information is periodically accessed continuously
     */
    @RequestMapping("update.in.real.time")
    public void updatedInRealTime(){
        Folder folder = null;
        Document document = null;
        for (File file : FolderLocalUtil.scannerFileAll(rootPath)) {
            if(file.isDirectory()){
                folder = folderServiceIn.selectFolder(file.getAbsolutePath());
                folder.setFolderName(file.getName());
                folder.setLastModify(new Date(file.lastModified()));
                folderServiceIn.save(folder);
            }else{
                document = documentServiceIn.selectDocument(file.getAbsolutePath());
                document.setDocumentName(file.getName());
                document.setLastModify(new Date(file.lastModified()));
                documentServiceIn.save(document);
            }
        }
    }
}
