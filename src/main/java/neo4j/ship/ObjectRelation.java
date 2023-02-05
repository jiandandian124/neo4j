package neo4j.ship;

import lombok.Data;
import lombok.NoArgsConstructor;
import neo4j.entity.ChineseName;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "师徒")
public class ObjectRelation implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;
    @StartNode
    private ChineseName parent;
    @EndNode
    private Object child;
    @Property
    private String relation;
    public ObjectRelation(ChineseName parent, Object child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}
