package edu.uark.laserbacks.game;

import edu.uark.laserbacks.player.Player;

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
