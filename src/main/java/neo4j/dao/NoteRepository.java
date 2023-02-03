package neo4j.dao;

import neo4j.entity.Node;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends Neo4jRepository<Node,Long> {
    /**
     * 查询某个节点的所有子节点
     * @param pId
     * @return
     */
    @Query("Match (p:person) -[*]->(s:person) where id(p)={0} return s")
    List<Node> findChildList(Long pId);
    @Query("Match (p:person {name:{0}}) -[*]->(s:person) return s")
    List<Node> findChildList(String name);
    /**
     * 查询当前节点的父节点
     * @param name
     * @return
     */
    @Query("Match (p:person) -[*]->(s:person {name:{0}}) return p")
    List<Node> findParentList(String name);
}
