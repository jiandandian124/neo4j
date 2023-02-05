package neo4j.ship;

import lombok.Data;
import lombok.NoArgsConstructor;
import neo4j.entity.ChineseName;
import neo4j.entity.MolecularWeight;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "分子量")
public class MolecularWeightRelation implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;
    @StartNode
    private ChineseName parent;
    @EndNode
    private MolecularWeight child;
    @Property
    private String relation;
    public MolecularWeightRelation(ChineseName parent, MolecularWeight child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}

