package tn.esprit.vaccination.domain.VaccineType;

import lombok.Data;
import tn.esprit.vaccination.domain.Vaccine.Vaccine;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "vaccines_types")
@Data
public class VaccineType {
    @Id
    @GeneratedValue
    private int id ;
    private String type;
    private int duration;

    @OneToMany(mappedBy = "vaccineType",cascade = CascadeType.REMOVE)
    private List<Vaccine> vaccines;

    public VaccineType(int id, String type, int duration, List<Vaccine> vaccines) {
        this.id = id;
        this.type = type;
        this.duration = duration;
        this.vaccines = vaccines;
    }

    public VaccineType() {
    }
}
