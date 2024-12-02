package naver.kiel0103.eksprac2024.domain.model;

import lombok.Getter;
import naver.kiel0103.eksprac2024.persistence.entity.RegionEntity;

import java.time.LocalDateTime;

@Getter
public class Region {

    private final Long regionId;
    private final String regionName;
    private final LocalDateTime createdAt;

    public Region(Long regionId, String regionName, LocalDateTime createdAt) {
        if (regionName == null || regionName.isEmpty()) {
            throw new IllegalArgumentException("Region name cannot be null or empty");
        }
        this.regionId = regionId;
        this.regionName = regionName;
        this.createdAt = createdAt;
    }

    public Region(RegionEntity regionEntity) {
        this(
                regionEntity.getRegionId(),
                regionEntity.getRegionName(),
                regionEntity.getCreatedAt()
        );
    }
}
