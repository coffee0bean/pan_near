package top.pan.repository;
/**
 * @Author coffee0bean
 * @Description
 * @Date 15:31 2020/5/25
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
@NoRepositoryBean
public interface BaseRepository<T,ID> extends JpaRepository<T,ID> {
}

