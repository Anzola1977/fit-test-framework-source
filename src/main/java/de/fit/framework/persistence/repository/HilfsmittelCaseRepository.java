package de.fit.framework.persistence.repository;
import de.fit.framework.persistence.entity.HilfsmittelCaseEntity;import org.springframework.data.jpa.repository.*;import java.util.*;
public interface HilfsmittelCaseRepository extends JpaRepository<HilfsmittelCaseEntity,Long>{@EntityGraph(attributePaths={"positions","positions.appointments"})Optional<HilfsmittelCaseEntity> findDetailedById(Long id);}
