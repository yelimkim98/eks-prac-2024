package naver.kiel0103.eksprac2024.persistence.repository;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import naver.kiel0103.eksprac2024.persistence.entity.RegionEntity;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

import java.time.LocalDateTime;
import java.util.List;

import static com.ninja_squad.dbsetup.Operations.*;
import static org.assertj.core.api.Assertions.assertThat;

/*
 이 클래스는 빌드를 할 때 테스트 용으로 사용이 되고
 빌드 결과물을 만들 때 자동 소멸된다.
 */
@SpringBootTest
class RegionRepositoryTest {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    private DataSource dataSource;

    @Test
    @Tag("DB Required")
    void test() {
        prepareDatabase();
        List<RegionEntity> result = regionRepository.findAll();
        assertThat(result).hasSize(4);
    }

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
}
