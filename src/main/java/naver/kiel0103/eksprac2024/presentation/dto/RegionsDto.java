package naver.kiel0103.eksprac2024.presentation.dto;

import lombok.Builder;
import lombok.Getter;
import java.util.List;

@Getter
@Builder
public class RegionsDto {

    private List<RegionDto> regionDtoList;
}
