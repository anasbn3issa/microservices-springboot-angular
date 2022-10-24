package com.esprit.microservice.entities;

import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
public class Pet {
    
    private String _id, name, type, race ;
    private int age;
    private Date captureDate;

    public Pet() {
    }
}
