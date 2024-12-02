package naver.kiel0103.eksprac2024.presentation;

import lombok.RequiredArgsConstructor;
import naver.kiel0103.eksprac2024.domain.service.RegionService;
import naver.kiel0103.eksprac2024.presentation.dto.RegionDto;
import naver.kiel0103.eksprac2024.presentation.dto.RegionsDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RegionApi {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegionApi.class);

    private final RegionService regionService;

    @GetMapping("/regions")
    public ResponseEntity<RegionsDto> getRegions() {
        LOGGER.info("getRegions");

        return ResponseEntity.ok(RegionsDto.builder()
                .regionDtoList(
                        regionService.getAllRegions().stream()
                                .map(region -> RegionDto.builder()
                                        .regionId(region.getRegionId())
                                        .regionName(region.getRegionName())
                                        .build())
                                .toList()
                )
                .build());
    }
}
