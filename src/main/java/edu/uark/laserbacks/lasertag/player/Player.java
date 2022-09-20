package edu.uark.laserbacks.lasertag.player;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Player {
    @Id @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String codeName;
}
