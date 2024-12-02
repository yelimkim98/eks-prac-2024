package naver.kiel0103.eksprac2024.presentation;

import naver.kiel0103.eksprac2024.persistence.repository.RegionRepository;
import naver.kiel0103.eksprac2024.presentation.dto.RegionsDto;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegionApiTest {

    @Autowired
    private RegionApi regionApi;

    /*
     @Mock 역할

     */
    @Mock
    private RegionRepository regionRepository;

    @Test
    void getRegions() {
        ResponseEntity<RegionsDto> result = regionApi.getRegions();
        assertThat(result.getBody()).isNotNull();
        assertThat(result.getBody().getRegionDtoList()).hasSize(4);
    }
}