package neo4j.ship;

import lombok.Data;
import lombok.NoArgsConstructor;
import neo4j.entity.CAS;
import neo4j.entity.ChineseName;
import neo4j.entity.Node;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "CAS")
public class CASRelation implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;
    @StartNode
    private ChineseName parent;
    @EndNode
    private CAS child;
    @Property
    private String relation;
    public CASRelation(ChineseName parent, CAS child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}
