package tn.esprit.ms.reward;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Reward implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int quantity;
    
}