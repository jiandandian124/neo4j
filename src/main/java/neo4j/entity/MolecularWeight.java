package neo4j.entity;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@Builder
@NodeEntity("MolecularWeight")
public class MolecularWeight implements Serializable {
    //分子量
    @Id
//    @GeneratedValue
    private Long id;
    @Property("name")
    private String name;
}