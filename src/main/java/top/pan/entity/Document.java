package top.pan.entity;
/**
 * @Author coffee0bean
 * @Description
 * @Date 15:30 2020/5/25
 */
import com.alibaba.fastjson.JSON;
import com.terran4j.commons.api2doc.annotations.ApiComment;
import lombok.*;

import javax.persistence.*;
import java.util.Map;

@Data@EqualsAndHashCode
@Entity
@Table(name = "document")
public class Document extends BaseEntity {

    @ApiComment(value = "id",sample = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NonNull
    @ApiComment(value = "Document Name",sample = "test.txt")
    @Column(name = "document_name",columnDefinition = "varchar(255) not null")
    private String documentName;

    public String toString(){
        return JSON.toJSONString(this);
    }

    public Map<String,Object> toJson(){
        Map<String,Object> map = super.toJson();
        map.put("id",id);
        map.put("documentName",documentName);
        return map;
    }
}
