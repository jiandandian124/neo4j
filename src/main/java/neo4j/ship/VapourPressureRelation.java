package neo4j.ship;

import lombok.Data;
import lombok.NoArgsConstructor;
import neo4j.entity.ChineseName;
import neo4j.entity.VapourPressure;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "蒸汽压")
public class VapourPressureRelation implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;
    @StartNode
    private ChineseName parent;
    @EndNode
    private VapourPressure child;
    @Property
    private String relation;
    public VapourPressureRelation(ChineseName parent, VapourPressure child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}


