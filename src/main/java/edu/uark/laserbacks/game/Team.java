package edu.uark.laserbacks.game;

import edu.uark.laserbacks.player.Player;
import lombok.Data;

import java.util.HashMap;
import java.util.List;

@Data
public class Team {
    private HashMap<Integer, Player> players = new HashMap<>();

    public Team(List<Player> players){
        for(Player player : players){
            this.players.put(player.getId(), player);
        }
    }
}