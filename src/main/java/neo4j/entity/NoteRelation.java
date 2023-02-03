package neo4j.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@NoArgsConstructor
@RelationshipEntity(type = "师徒")
public class NoteRelation implements Serializable {

    @Id
//    @GeneratedValue
    private Long id;
    @StartNode
    private Node parent;
    @EndNode
    private Node child;
    @Property
    private String relation;
    public NoteRelation(Node parent, Node child, String relation) {
        this.parent = parent;
        this.child = child;
        this.relation = relation;
    }
}
