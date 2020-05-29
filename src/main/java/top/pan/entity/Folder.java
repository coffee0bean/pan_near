package top.pan.entity;
/**
 * @Author coffee0bean
 * @Description
 * @Date 15:31 2020/5/25
 */
import com.terran4j.commons.api2doc.annotations.ApiComment;
import lombok.*;

import javax.persistence.*;
import java.util.Map;

/**
 * 文件夹实体类
 * 实体类其实用不到 只是想有创建时间功能
 */
@Data@EqualsAndHashCode@ToString
@Entity(name = "folder")
@Table(name = "folder")
public class Folder extends BaseEntity {

    @ApiComment(value = "folder id", sample = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ApiComment(value = "folder name",sample = "test")
    @Column(name = "folder_name",columnDefinition = "varchar(225) not null")
    private String folderName;

    @Override
    public String toString() {
        return "Folder{" +
                "id=" + id +
                ", folderName='" + folderName + '\'' +
                ", createDate='" + super.getCreateDate() +
                ", absolutePath='" + super.getAbsolutePath() +
                "' }";
    }

    public Map<String,Object> toJson(){
        Map<String,Object> map = super.toJson();
        map.put("id",id);
        map.put("folderName",folderName);
        return map;
    }


}
