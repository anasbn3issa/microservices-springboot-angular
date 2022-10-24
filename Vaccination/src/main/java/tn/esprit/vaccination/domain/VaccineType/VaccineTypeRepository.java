package tn.esprit.vaccination.domain.VaccineType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import tn.esprit.vaccination.domain.Vaccine.Vaccine;

@Repository
@CrossOrigin("*")
public interface VaccineTypeRepository extends JpaRepository<VaccineType, Integer> {
}
