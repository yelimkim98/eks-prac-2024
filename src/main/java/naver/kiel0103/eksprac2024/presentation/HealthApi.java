package naver.kiel0103.eksprac2024.presentation;

import lombok.RequiredArgsConstructor;
import naver.kiel0103.eksprac2024.presentation.dto.HealthDto;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins="*", allowedHeaders = "*")
public class HealthApi {

    private static final Logger LOGGER = Logger.getLogger(HealthApi.class.getName());

    /*
     이렇게 MediaType 을 명시적으로 지정할 수 있음.
     하지만 RestController 는 JSON 형식의 데이터 반환이 default 라서
     사실 이렇게 지정할 필요는 없다.
     */
    @GetMapping(value = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HealthDto> health() {
        LOGGER.info("Health check started");

        return ResponseEntity.ok(HealthDto.builder()
                .status("OK")
                .build());
    }
}
