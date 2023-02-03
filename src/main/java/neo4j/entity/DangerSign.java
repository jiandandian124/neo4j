package neo4j.entity;

import lombok.Builder;
import lombok.Data;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Data
@Builder
@NodeEntity("DangerSign")
public class DangerSign implements Serializable {
    //危险标记
    @Id
//    @GeneratedValue
    private Long id;
    @Property("name")
    private String name;
}
