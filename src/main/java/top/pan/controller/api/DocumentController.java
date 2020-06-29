package top.pan.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.pan.service.DocumentServiceIn;
import top.pan.service.FolderServiceIn;

/**
 * @Author coffee0bean
 * @Description
 * @Date 9:58 2020/5/29
 */
@RestController@RequestMapping("api/document")
public class DocumentController extends BaseController {
    public DocumentController(FolderServiceIn folderServiceIn, DocumentServiceIn documentServiceIn) {
        super(folderServiceIn, documentServiceIn);
    }

    @RequestMapping("upload.document")
    public String uploadDocument(@RequestParam("upload_file") MultipartFile [] upload_file,@RequestParam("currentPath") String currentPath){
        for (int i = 0; i < upload_file.length; i++) {
            System.out.println(upload_file[i]);
        }
        return "false";
    }
}
