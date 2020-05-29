package top.pan;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class PanNearApplicationTests {

    @Value("${root.path}")
    private String rootPath;
    @Test
    void contextLoads() {
        File file = new File(rootPath);
        if(!file.exists()){
            file.mkdir();
        }
    }

}
