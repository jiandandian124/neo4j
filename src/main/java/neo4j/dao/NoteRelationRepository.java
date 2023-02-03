package neo4j.dao;

import neo4j.ship.NoteRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRelationRepository extends
        Neo4jRepository<NoteRelation,Long> {
}
