package neo4j.ship;

import lombok.Data;
import lombok.NoArgsConstructor;
import neo4j.entity.Alias;
import neo4j.entity.ChineseName;
import neo4j.entity.Node;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "别名")
public class AliasRelation implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;
    @StartNode
    private ChineseName parent;
    @EndNode
    private Alias child;
    @Property
    private String relation;
    public AliasRelation(ChineseName parent, Alias child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}

