package tn.esprit.vaccination.domain;

import lombok.Data;
import tn.esprit.vaccination.domain.Vaccine.Vaccine;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Pet {
    @Id
    @GeneratedValue
    private int id;

    private int idPet;

    @ManyToOne
    @JoinColumn(name = "vaccine")
    private Vaccine vaccine ;

    public Pet() {
    }
}
