package top.pan.entity;
/**
 * @Author coffee0bean
 * @Description
 * @Date 15:31 2020/5/25
 */
import lombok.*;

@Data@ToString@EqualsAndHashCode
@AllArgsConstructor
public class Result {
    @NonNull
    private String key;

    @NonNull
    private Object value;
}
