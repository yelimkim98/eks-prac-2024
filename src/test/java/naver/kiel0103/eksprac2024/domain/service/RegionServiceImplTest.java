package naver.kiel0103.eksprac2024.domain.service;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import naver.kiel0103.eksprac2024.domain.model.Region;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

import static com.ninja_squad.dbsetup.Operations.*;

/*
@SpringBootTest
@Configuration, @Component, @Service, @Repository, @Controller 등
스프링 Bean 들이 스캔되어 등록됩니다.
애플리케이션이 실제로 동작할 때와 유사한 환경을 제공합니다.

내장 데이터베이스, 기본 웹 서버(Mock MVC 포함),
설정 파일(application.properties 또는 application.yml) 등이 자동으로 로드됨
 */
@SpringBootTest
class RegionServiceImplTest {

    @Autowired
    private RegionService regionService;

    @Autowired
    private DataSource dataSource;

    @BeforeEach
    void prepareDatabase() {
        Operation operations = sequenceOf(
                deleteAllFrom("region"),
                insertInto("region")
                        .columns("region_id", "region_name", "creation_timestamp")
                        .values(1, "지역1", LocalDateTime.now())
                        .values(2, "지역2", LocalDateTime.now())
                        .values(3, "지역3", LocalDateTime.now())
                        .values(4, "지역4", LocalDateTime.now())
                        .build()
        );
        DbSetup dbSetup = new DbSetup(new DataSourceDestination(dataSource), operations);
        dbSetup.launch();
    }

    @Test
    @Tag("DBRequired")
    public void testServiceRegion(){
        List<Region> regionList = regionService.getAllRegions();
        Assertions.assertEquals(regionList.size(), 4);
    }
}
