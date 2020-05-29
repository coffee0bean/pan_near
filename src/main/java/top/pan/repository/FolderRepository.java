package top.pan.repository;
/**
 * @Author coffee0bean
 * @Description
 * @Date 15:31 2020/5/25
 */
import top.pan.entity.Folder;

import java.util.Optional;

public interface FolderRepository extends BaseRepository<Folder,Long> {
    public Folder save(Folder folder);

    public Optional<Folder> findAllByAbsolutePath(String absolutePath);
}
