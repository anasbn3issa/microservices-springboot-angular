package tn.esprit.ms.local;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Local implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    private Boolean status;
    
}