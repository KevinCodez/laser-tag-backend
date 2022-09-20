package edu.uark.laserbacks.lasertag.game;

import edu.uark.laserbacks.lasertag.player.Player;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Hits {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    private Team team;
    @ManyToOne
    private Player shooter;
    @ManyToOne
    private Player tagged;
}
