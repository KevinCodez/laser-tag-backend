package edu.uark.laserbacks.game;

import edu.uark.laserbacks.player.Player;
import lombok.Data;

import java.util.List;

@Data
public class Team {
    private String name;
    private Integer score;
    private List<Player> players;
}

