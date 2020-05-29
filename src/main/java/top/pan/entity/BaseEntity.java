package top.pan.entity;
/**
 * @Author coffee0bean
 * @Description
 * @Date 15:30 2020/5/25
 */
import com.terran4j.commons.api2doc.annotations.ApiComment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Data@ToString@EqualsAndHashCode
@MappedSuperclass
public class BaseEntity {

    @ApiComment(value = "Absolute path",sample = "F:/test/pan_near/test")
    @Column(name = "absolute_path",columnDefinition = "varchar(255) not null",unique = true)
    private String absolutePath;

    @ApiComment(value = "Create Date",sample = "2020-01-01 01:01:01")
    @Column(name = "create_date",columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @ApiComment(value = "isDir",sample = "true")
    @Column(name = "isDir",columnDefinition = "boolean default true")
    private Boolean isDir;

    @ApiComment(value = "Create Date",sample = "2020-01-01 01:01:01")
    @Column(name = "last_modify",columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModify;

    public Map<String,Object> toJson(){
        Map<String,Object> map = new HashMap<>();
        map.put("absolutePath",absolutePath);
        map.put("createDate",createDate);
        map.put("isDir",isDir);
        map.put("lastModify",lastModify);
        return map;
    }

}
