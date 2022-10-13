package tn.esprit.vaccination.domain.Vaccine;

import lombok.Data;
import tn.esprit.vaccination.domain.Pet;
import tn.esprit.vaccination.domain.VaccineType.VaccineType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vaccines")
@Data
public class Vaccine {
    @Id
    @GeneratedValue
    private int id ;
    private String name;
    private Boolean validity;
    private int quantity;

    @OneToMany(mappedBy = "vaccine",cascade = CascadeType.REMOVE)
    private List<Pet> pets;


    @ManyToOne
    @JoinColumn(name = "vaccine_type_id")
    private VaccineType vaccineType;


    public Vaccine(int id, String name, Boolean validity, int quantity, List<Pet> pets, VaccineType vaccineType) {
        this.id = id;
        this.name = name;
        this.validity = validity;
        this.quantity = quantity;
        this.pets = pets;
        this.vaccineType = vaccineType;
    }

    public Vaccine() {
    }
}
