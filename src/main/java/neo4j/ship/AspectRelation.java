package neo4j.ship;

import lombok.Data;
import lombok.NoArgsConstructor;
import neo4j.entity.Aspect;
import neo4j.entity.ChineseName;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "外观与性状")
public class AspectRelation implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;
    @StartNode
    private ChineseName parent;
    @EndNode
    private Aspect child;
    @Property
    private String relation;
    public AspectRelation(ChineseName parent, Aspect child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}

