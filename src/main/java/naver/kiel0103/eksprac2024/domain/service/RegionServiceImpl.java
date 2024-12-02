package naver.kiel0103.eksprac2024.domain.service;

import lombok.RequiredArgsConstructor;
import naver.kiel0103.eksprac2024.domain.model.Region;
import naver.kiel0103.eksprac2024.persistence.repository.RegionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegionServiceImpl implements RegionService{

    private final RegionRepository regionRepository;

    @Override
    public List<Region> getAllRegions() {
        return regionRepository.findAll().stream()
                .map(Region::new)
                .toList();
    }
}
