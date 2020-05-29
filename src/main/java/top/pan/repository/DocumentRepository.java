package top.pan.repository;
/**
 * @Author coffee0bean
 * @Description
 * @Date 15:31 2020/5/25
 */
import top.pan.entity.Document;

import java.util.Optional;

public interface DocumentRepository extends BaseRepository<Document,Integer> {
    public Document save(Document document);

    public Optional<Document> findDocumentByAbsolutePath(String absolutePath);
}
