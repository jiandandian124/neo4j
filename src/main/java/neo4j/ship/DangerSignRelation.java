package neo4j.ship;

import lombok.Data;
import lombok.NoArgsConstructor;
import neo4j.entity.ChineseName;
import neo4j.entity.DangerSign;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "危险标记")
public class DangerSignRelation implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;
    @StartNode
    private ChineseName parent;
    @EndNode
    private DangerSign child;
    @Property
    private String relation;
    public DangerSignRelation(ChineseName parent, DangerSign child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}


