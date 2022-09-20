package edu.uark.laserbacks.lasertag.player;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Player {
    @Id @GeneratedValue
    private Integer id;
    private String codeName;
}
