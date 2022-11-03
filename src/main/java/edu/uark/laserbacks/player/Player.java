package edu.uark.laserbacks.player;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Player {
    @Id
    @Column(unique = true)
    private Integer id;
    @Column(unique = true, length = 30)
    private String codename;
    @Transient
    private Integer score;
}
