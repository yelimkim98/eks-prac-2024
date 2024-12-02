package naver.kiel0103.eksprac2024.presentation;

import naver.kiel0103.eksprac2024.presentation.dto.HealthDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HealthApiTest {

    @Test
    void health() {
        HealthApi healthApi = new HealthApi();
        ResponseEntity<HealthDto> result = healthApi.health();
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getStatus()).isEqualTo("OK");
    }
}
