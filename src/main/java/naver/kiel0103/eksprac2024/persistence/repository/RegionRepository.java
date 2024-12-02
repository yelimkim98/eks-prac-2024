package naver.kiel0103.eksprac2024.persistence.repository;

import naver.kiel0103.eksprac2024.persistence.entity.RegionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 RegionEntity 와 연결된 테이블에 CRUD 작업을 수행할 수 있는 기본 메서드를 구현한 인스턴스를 자동으로 생성

 Proxy 패턴을 이용해서
 RegionRepository를 implement한 class를 만들어서 컴포넌트로 등록해줌
 */
public interface RegionRepository extends JpaRepository<RegionEntity, Long> {

    /*
     다음 다섯개의 메서드는 기본적으로 제공돼서 별도로 정의할 필요가 없다.
     - Entity를 매개변수로 받아서 삽입, 수정, 삭제하는 메서드
     - 매개변수 없이 모든 데이터를 읽어오는 메서드
     - 기본키를 매개변수로 받아서 하나의 데이터를 읽어오는 메서드
     */
    List<RegionEntity> findAllByRegionName(String regionName);
}
