package htw.berlin.weatherbackend.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
// für Datenbank
    List<CityEntity> findAllByName (String name);



}
