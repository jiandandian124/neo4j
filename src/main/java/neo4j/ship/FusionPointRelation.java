package neo4j.ship;

import lombok.Data;
import lombok.NoArgsConstructor;
import neo4j.entity.ChineseName;
import neo4j.entity.FusionPoint;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "熔点")
public class FusionPointRelation implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;
    @StartNode
    private ChineseName parent;
    @EndNode
    private FusionPoint child;
    @Property
    private String relation;
    public FusionPointRelation(ChineseName parent, FusionPoint child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}

