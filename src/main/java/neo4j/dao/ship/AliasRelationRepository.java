package neo4j.dao.ship;

import neo4j.ship.AliasRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AliasRelationRepository extends
        Neo4jRepository<AliasRelation,Long> {
}
