package top.pan.local;


import org.springframework.beans.factory.annotation.Value;
import top.pan.entity.Folder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author coffee0bean
 * @Description Operates on the local folder class
 * @Date 15:30 2020/5/25
 */
public class FolderLocalUtil {


    public static List<File> scannerFile(String rootPath) {
        List<File> list = new ArrayList<>();
        File file = new File(rootPath);
        File[] files = file.listFiles();
        if (files == null) {
            return null;
        }
        for (File f : files) {
            list.add(f);
        }
        return list;
    }

    public static File mkdirFolder(String absolutePath, String folderName) {
        File file = new File(absolutePath + "/" + folderName);
        if (!file.exists()) {
            file.mkdir();
        }
        return file;
    }

    public static List<File> scannerFileAll(String rootPath) {
        List<File> fileList = new ArrayList<File> ();
        File file = new File(rootPath);
        File[] files = file.listFiles();
        if (files == null) {
            return null;
        }
        for (File f : files) {
            fileList.add(f);
            if (f.isFile()) {
            } else if (f.isDirectory()) {
                List<File> list = scannerFileAll(f.getAbsolutePath());
                for (File fi : list) {
                    fileList.add(fi);
                }
            }
        }
        return fileList;
    }
}
