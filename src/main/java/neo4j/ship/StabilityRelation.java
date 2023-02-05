package neo4j.ship;

import lombok.Data;
import lombok.NoArgsConstructor;
import neo4j.entity.ChineseName;
import neo4j.entity.Stability;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "稳定性")
public class StabilityRelation implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;
    @StartNode
    private ChineseName parent;
    @EndNode
    private Stability child;
    @Property
    private String relation;
    public StabilityRelation(ChineseName parent, Stability child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}


