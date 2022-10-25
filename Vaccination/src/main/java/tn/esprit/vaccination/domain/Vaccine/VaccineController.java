package tn.esprit.vaccination.domain.Vaccine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VaccineController {

    @Autowired
    VaccineService vaccineService;

    @GetMapping("/vaccines/count/{id}")
    public int getNbrVaccinesByType(@PathVariable("id") int id){
        return vaccineService.nbrOfVaccineByType(id);
    }
}
