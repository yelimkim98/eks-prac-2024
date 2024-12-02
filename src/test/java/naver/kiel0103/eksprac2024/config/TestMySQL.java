package naver.kiel0103.eksprac2024.config;

import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers // Testcontainers 관리를 위한 어노테이션
public class TestMySQL {

    /*
     MySQLContainer는 AutoCloseable을 구현하고 있으므로
     리소스 누수 방지를 위해
     테스트 실행 후 컨테이너를 명시적으로 종료하거나
     try-with-resources를 사용하는 것이 필요합니다.

     하지만 @Container로 선언하면
     Testcontainers가 자동으로 컨테이너의 수명 주기를 관리하므로
     별도의 종료 코드가 필요하지 않습니다.
     */
    @Container
    static MySQLContainer<?> mysqlContainer = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test")
            .withInitScript("schema.sql");
}
