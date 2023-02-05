package neo4j.ship;


import lombok.Data;
import lombok.NoArgsConstructor;
import neo4j.entity.ChineseName;
import neo4j.entity.EnglishName;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "英文名称")
public class EnglishNameRelation implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;
    @StartNode
    private ChineseName parent;
    @EndNode
    private EnglishName child;
    @Property
    private String relation;
    public EnglishNameRelation(ChineseName parent, EnglishName child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}

