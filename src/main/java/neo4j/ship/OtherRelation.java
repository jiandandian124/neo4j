package neo4j.ship;

import lombok.Data;
import lombok.NoArgsConstructor;
import neo4j.entity.ChineseName;
import neo4j.entity.Other;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "其他")
public class OtherRelation implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;
    @StartNode
    private ChineseName parent;
    @EndNode
    private Other child;
    @Property
    private String relation;
    public OtherRelation(ChineseName parent, Other child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}


