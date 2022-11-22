package edu.uark.laserbacks.game;

import edu.uark.laserbacks.player.Player;
import lombok.Data;

@Data
public class Hits {
    private Integer id;
    private Team team;
    private Player shooter;
    private Player tagged;
}
