package neo4j.ship;

import lombok.Data;
import lombok.NoArgsConstructor;
import neo4j.entity.ChineseName;
import neo4j.entity.Density;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "密度")
public class DensityRelation implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;
    @StartNode
    private ChineseName parent;
    @EndNode
    private Density child;
    @Property
    private String relation;
    public DensityRelation(ChineseName parent, Density child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}


