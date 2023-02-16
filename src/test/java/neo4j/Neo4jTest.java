package neo4j;


import neo4j.dao.note.ChineseNameRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Neo4jTest {

    @Autowired
    private ChineseNameRepository chineseNameRepository;

    @Test
    public void test(){

        String title = new String("乙醇");
        String density = chineseNameRepository.getDensity(title);
        System.out.println(density);

    }
}
