package edu.uark.laserbacks.player;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Player {
    @Id
    @Column(unique = true)
    private Integer id;
    @Column(unique = true, length = 30)
    private String codename;
}
