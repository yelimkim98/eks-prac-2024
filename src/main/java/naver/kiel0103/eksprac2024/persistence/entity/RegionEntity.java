package naver.kiel0103.eksprac2024.persistence.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "REGION")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegionEntity extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REGION_ID")
    private Long regionId;

    @Column(name = "REGION_NAME", nullable = false, length = 100)
    private String regionName;

    @Column(name = "CREATION_TIMESTAMP", nullable = false)
    private LocalDateTime createdAt;
}
