package neo4j.dao.note;

import neo4j.entity.ChineseName;
import neo4j.entity.Node;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChineseNameRepository extends Neo4jRepository<ChineseName,Long> {
    /**
     * 查询某个节点的所有子节点
     * @param pId
     * @return
     */
    @Query("Match (p:ChineseName) -[*]->(s:ChineseName) where id(p)={0} return s")
    List<ChineseName> findChildList(Long pId);
    @Query("Match (p:ChineseName {name:{0}}) -[*]->(s:ChineseName) return s")
    List<ChineseName> findChildList(String name);
    /**
     * 查询当前节点的父节点
     * @param name
     * @return
     */
    @Query("Match (p:ChineseName) -[*]->(s:ChineseName {name:{0}}) return p")
    List<ChineseName> findParentList(String name);
}

