package tn.esprit.vaccination.domain.VaccineType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.vaccination.domain.Vaccine.Vaccine;

@Repository
public interface VaccineTypeRepository extends JpaRepository<VaccineType, Integer> {
}
