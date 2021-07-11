package pl.sda.humanresource.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface PositionRepository extends JpaRepository<PositionEntity, Long> {

    List<PositionEntity> findAllByPositionType(String workType);


}
