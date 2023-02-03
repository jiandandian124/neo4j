package neo4j;

import neo4j.dao.NoteRepository;
import neo4j.dao.NoteRelationRepository;
import neo4j.dao.note.ChineseNameRepository;
import neo4j.dao.ship.AliasRelationRepository;
import neo4j.entity.Alias;
import neo4j.entity.ChineseName;
import neo4j.entity.Node;
import neo4j.ship.AliasRelation;
import neo4j.ship.NoteRelation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class Neo4jApplicationTest {

    @Autowired
    private NoteRelationRepository noteRelationRepository;
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private ChineseNameRepository chineseNameRepository;

    @Autowired
    private AliasRelationRepository aliasRelationRepository;


    @Test
    public void testCreate1(){
        ChineseName chineseName1 = ChineseName.builder().name("氨").build();
        List<ChineseName> chineseNameList = new ArrayList<>(Arrays.asList(
                chineseName1));
        chineseNameRepository.saveAll(chineseNameList);

        Alias alias = Alias.builder().name("氨气").build();

        AliasRelation aliasRelation = new AliasRelation(chineseName1,alias,"别名");
        List<AliasRelation> aliasRelationList = new ArrayList<>(Arrays.asList(
                aliasRelation));
        aliasRelationRepository.saveAll(aliasRelationList);
    }


    @Test
    public void testCreate(){
        Node person = Node.builder().name("唐僧").build();
        Node person2 = Node.builder().name("孙悟空").build();
        Node person3 = Node.builder().name("猪八戒").build();
        Node person4 = Node.builder().name("沙僧").build();
        Node person5 = Node.builder().name("白龙马").build();
        List<Node> personList = new ArrayList<>(Arrays.asList(
                person,person2,person3,person4,person5));
        //保存节点数据
        noteRepository.saveAll(personList);
        NoteRelation noteRelation = new NoteRelation(person,person2,"大徒弟");
        NoteRelation noteRelation2 = new NoteRelation(person,person3,"二徒弟");
        NoteRelation noteRelation3 = new NoteRelation(person,person4,"三徒弟");
        NoteRelation noteRelation4 = new NoteRelation(person,person5,"四徒弟");
        List<NoteRelation> noteRelationList = new ArrayList<>(Arrays.asList(
                noteRelation, noteRelation2, noteRelation3,
                noteRelation4));
        // 保存关系数据
        noteRelationRepository.saveAll(noteRelationList);
    }

    @Test
    public void testfindById(){
        Optional<Node> byId = noteRepository.findById(5L);
        System.out.println(byId.orElse(null));
//        System.out.printf("1");
    }
    @Test
    public void testDeleteRelationShip(){
// 删除所有person节点
noteRepository.deleteAll();
// 删除所有personRelation关系数据
        noteRelationRepository.deleteAll();
    }
    @Test
    public void testDeletePerson(){
        //personRepository.deleteById(1L);
        noteRelationRepository.deleteById(1L);
    }
}
