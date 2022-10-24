package tn.esprit.vaccination.domain.Vaccine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("*")
public interface VaccineRepository extends JpaRepository<Vaccine , Integer> {
}
