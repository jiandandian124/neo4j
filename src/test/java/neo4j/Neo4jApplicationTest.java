package neo4j;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import neo4j.dao.NoteRepository;
import neo4j.dao.NoteRelationRepository;
import neo4j.dao.note.ChineseNameRepository;
import neo4j.dao.ship.AliasRelationRepository;
import neo4j.entity.*;
import neo4j.ship.*;
import org.bson.Document;
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
    public void testMongodb(){
        MongoClient mc = new MongoClient("localhost",27017);

        //从链接对象中拿到库对象
        MongoDatabase database = mc.getDatabase("msds");
//从库对象中拿到某个集合（表）
        MongoCollection<Document> collection = database.getCollection("msds_zhongyu");

        //调用find方法，拿到表中的数据，是一个二进制格式的文档
        FindIterable<Document> find = collection.find();

//将拿到的文档进行迭代器迭代，拿到迭代器对象
        MongoCursor<Document> iterator = find.iterator();

//hasNext进行判断是否有下一条
        int i = 0;

//        while(iterator.hasNext()) {
//            i++;
//            Document next = iterator.next();
//            System.out.println(next.get("外观与性状"));
//            System.out.println(i);
//        }

        Document document = iterator.next();
        testCreate3(document);

        mc.close();
    }
    @Test
    public void testCreate3(Document next){
        //得到mongodb数据库中的文档，并转为String
        String chineseName1 = next.get("外观与性状").toString();




        ChineseName chineseName = ChineseName.builder().name("阿斯顿发").build();
//        List<ChineseName> chineseNameList = new ArrayList<>(Arrays.asList(
//                chineseName1));
//        chineseNameRepository.saveAll(chineseNameList);
//可以少些note结点仓库，不过无法省略关系仓库
        // TODO: 2023/2/3 继续写关系仓库 以及关系结点
        //实体创建
        Alias alias = Alias.builder().name("爱是解放军气").build();
        Aspect aspect = Aspect.builder().name("好看").build();
        CAS cas = CAS.builder().name("46545-5454").build();
        DangerSign dangerSign = DangerSign.builder().name("危险").build();
        Density density = Density.builder().name("密度").build();
        EnglishName englishName = EnglishName.builder().name("英文名称").build();
        FusionPoint fusionPoint = FusionPoint.builder().name("熔点").build();
        MolecularFormula molecularFormula = MolecularFormula.builder().name("分子式").build();
        MolecularWeight molecularWeight = MolecularWeight.builder().name("分子量").build();
        Other other = Other.builder().name("其他").build();
        Solubleness solubleness = Solubleness.builder().name("溶解性").build();
        Stability stability = Stability.builder().name("稳定性").build();
        Use use = Use.builder().name("用途").build();
        VapourPressure vapourPressure = VapourPressure.builder().name("蒸汽压").build();



        //关系创建
        AliasRelation aliasRelation = new AliasRelation(chineseName,alias,"别名");
        AspectRelation aspectRelation = new AspectRelation(chineseName,aspect,"外观与性状");
        CASRelation casRelation = new CASRelation(chineseName,cas,"CAS");
        DangerSignRelation dangerSignRelation = new DangerSignRelation(chineseName,dangerSign,"危险标记");
        DensityRelation densityRelation = new DensityRelation(chineseName,density,"密度");
        EnglishNameRelation englishNameRelation = new EnglishNameRelation(chineseName,englishName,"英文名称");
        FusionPointRelation fusionPointRelation = new FusionPointRelation(chineseName,fusionPoint,"熔点");
        MolecularFormulaRelation molecularFormulaRelation = new MolecularFormulaRelation(chineseName,molecularFormula,"分子式");
        MolecularWeightRelation molecularWeightRelation = new MolecularWeightRelation(chineseName,molecularWeight,"分子量");
        OtherRelation otherRelation = new OtherRelation(chineseName,other,"其他");
        SolublenessRelation solublenessRelation = new SolublenessRelation(chineseName,solubleness,"溶解性");
        StabilityRelation stabilityRelation = new StabilityRelation(chineseName,stability,"稳定性");
        UseRelation useRelation = new UseRelation(chineseName,use,"用途");
        VapourPressureRelation vapourPressureRelation = new VapourPressureRelation(chineseName,vapourPressure,"蒸汽压");

        //关系集合
        List<Object> aliasRelationList = new ArrayList<>(Arrays.asList(
                aliasRelation,aspectRelation,casRelation,dangerSignRelation,densityRelation,
                englishNameRelation,fusionPointRelation,molecularFormulaRelation,molecularWeightRelation,
                otherRelation,solublenessRelation,stabilityRelation,useRelation,vapourPressureRelation
        ));

        //保存数据
        noteRelationRepository.saveAll(aliasRelationList);
    }

    @Test
    public void testCreate2(){
        ChineseName chineseName1 = ChineseName.builder().name("阿斯顿发").build();
//        List<ChineseName> chineseNameList = new ArrayList<>(Arrays.asList(
//                chineseName1));
//        chineseNameRepository.saveAll(chineseNameList);
//可以少些note结点仓库，不过无法省略关系仓库
        // TODO: 2023/2/3 继续写关系仓库 以及关系结点
        //实体创建
        Alias alias = Alias.builder().name("爱是解放军气").build();
        Aspect aspect = Aspect.builder().name("好看").build();
        CAS cas = CAS.builder().name("46545-5454").build();
        DangerSign dangerSign = DangerSign.builder().name("危险").build();
        Density density = Density.builder().name("密度").build();
        EnglishName englishName = EnglishName.builder().name("英文名称").build();
        FusionPoint fusionPoint = FusionPoint.builder().name("熔点").build();
        MolecularFormula molecularFormula = MolecularFormula.builder().name("分子式").build();
        MolecularWeight molecularWeight = MolecularWeight.builder().name("分子量").build();
        Other other = Other.builder().name("其他").build();
        Solubleness solubleness = Solubleness.builder().name("溶解性").build();
        Stability stability = Stability.builder().name("稳定性").build();
        Use use = Use.builder().name("用途").build();
        VapourPressure vapourPressure = VapourPressure.builder().name("蒸汽压").build();



        //关系创建
        AliasRelation aliasRelation = new AliasRelation(chineseName1,alias,"别名");
        AspectRelation aspectRelation = new AspectRelation(chineseName1,aspect,"外观与性状");
        CASRelation casRelation = new CASRelation(chineseName1,cas,"CAS");
        DangerSignRelation dangerSignRelation = new DangerSignRelation(chineseName1,dangerSign,"危险标记");
        DensityRelation densityRelation = new DensityRelation(chineseName1,density,"密度");
        EnglishNameRelation englishNameRelation = new EnglishNameRelation(chineseName1,englishName,"英文名称");
        FusionPointRelation fusionPointRelation = new FusionPointRelation(chineseName1,fusionPoint,"熔点");
        MolecularFormulaRelation molecularFormulaRelation = new MolecularFormulaRelation(chineseName1,molecularFormula,"分子式");
        MolecularWeightRelation molecularWeightRelation = new MolecularWeightRelation(chineseName1,molecularWeight,"分子量");
        OtherRelation otherRelation = new OtherRelation(chineseName1,other,"其他");
        SolublenessRelation solublenessRelation = new SolublenessRelation(chineseName1,solubleness,"溶解性");
        StabilityRelation stabilityRelation = new StabilityRelation(chineseName1,stability,"稳定性");
        UseRelation useRelation = new UseRelation(chineseName1,use,"用途");
        VapourPressureRelation vapourPressureRelation = new VapourPressureRelation(chineseName1,vapourPressure,"蒸汽压");

        //关系集合
        List<Object> aliasRelationList = new ArrayList<>(Arrays.asList(
                aliasRelation,aspectRelation,casRelation,dangerSignRelation,densityRelation,
                englishNameRelation,fusionPointRelation,molecularFormulaRelation,molecularWeightRelation,
                otherRelation,solublenessRelation,stabilityRelation,useRelation,vapourPressureRelation
        ));

        //保存数据
        noteRelationRepository.saveAll(aliasRelationList);
    }
    @Test
    public void testCreate1(){
        ChineseName chineseName1 = ChineseName.builder().name("阿斯顿发").build();
//        List<ChineseName> chineseNameList = new ArrayList<>(Arrays.asList(
//                chineseName1));
//        chineseNameRepository.saveAll(chineseNameList);
//可以少些note结点仓库，不过无法省略关系仓库
        // TODO: 2023/2/3 继续写关系仓库 以及关系结点
        Alias alias = Alias.builder().name("爱是解放军气").build();

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
