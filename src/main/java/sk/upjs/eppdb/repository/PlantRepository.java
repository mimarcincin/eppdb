package sk.upjs.eppdb.repository;

import sk.upjs.eppdb.model.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {

}
