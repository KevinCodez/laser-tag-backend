package edu.uark.laserbacks.game;

import edu.uark.laserbacks.player.Player;
import lombok.Data;

import javax.persistence.*;

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
