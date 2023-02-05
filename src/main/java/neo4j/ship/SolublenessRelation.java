package neo4j.ship;

import lombok.Data;
import lombok.NoArgsConstructor;
import neo4j.entity.ChineseName;
import neo4j.entity.Solubleness;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "溶解性")
public class SolublenessRelation implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;
    @StartNode
    private ChineseName parent;
    @EndNode
    private Solubleness child;
    @Property
    private String relation;
    public SolublenessRelation(ChineseName parent, Solubleness child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}

