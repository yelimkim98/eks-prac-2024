package naver.kiel0103.eksprac2024.domain.service;

import naver.kiel0103.eksprac2024.domain.model.Region;

import java.util.List;

/*
 메소드 선언만
 */
public interface RegionService {

    //매개변수 없이 전체 데이터를 가져오는 메서드
     List<Region> getAllRegions();
}
