package tn.esprit.vaccination.domain.Vaccine;

import lombok.Data;
import tn.esprit.vaccination.domain.VaccineType.VaccineType;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "vaccine_type_id")
    private VaccineType vaccineType;

    public Vaccine(int id, String name, Boolean validity, int quantity, VaccineType vaccineType) {
        this.id = id;
        this.name = name;
        this.validity = validity;
        this.quantity = quantity;
        this.vaccineType = vaccineType;
    }

    public Vaccine() {
    }
}
