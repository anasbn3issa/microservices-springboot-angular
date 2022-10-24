package tn.esprit.vaccination.domain.Vaccine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.vaccination.domain.VaccineType.VaccineTypeRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class VaccineService {

    @Autowired
    VaccineRepository vaccineRepository;

    @Autowired
    VaccineTypeRepository vaccineTypeRepository;

    public int nbrOfVaccineByType(int idType){
        System.err.println(idType);
        List<Vaccine> vaccines = vaccineRepository.findAll();
        if(vaccineTypeRepository.findById(idType).isPresent()){
            int nbr = 0;
            for (Vaccine v: vaccines) {
                if (v.getVaccineType().getId()==idType)
                    nbr++;
            }
            return nbr;
        }
        return 0;
    }
}
