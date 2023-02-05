package neo4j.ship;

import lombok.Data;
import lombok.NoArgsConstructor;
import neo4j.entity.ChineseName;
import neo4j.entity.MolecularFormula;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "分子式")
public class MolecularFormulaRelation implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;
    @StartNode
    private ChineseName parent;
    @EndNode
    private MolecularFormula child;
    @Property
    private String relation;
    public MolecularFormulaRelation(ChineseName parent, MolecularFormula child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}

