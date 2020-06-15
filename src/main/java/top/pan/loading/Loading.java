package top.pan.loading;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * @Author coffee0bean
 * @Description
 * @Date 15:59 2020/5/28
 */
@Component
public class Loading implements CommandLineRunner {
    @Value("${root.path}")
    private String rootPath;
    @Override
    public void run(String... args) throws Exception {
        File file = new File(rootPath);
        if(!file.exists()){
            file.mkdir();
        }
    }

}
