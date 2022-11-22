package edu.uark.laserbacks.game;

import edu.uark.laserbacks.player.Player;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private Game game;

    public GameService(Game game){
        this.game = game;
    }

    // Score manipulation methods(these may need to be moved to the game class depending on how frontend data is received)
    public void incrementPlayerKills(int id){
        Player player = game.getTeam1().getPlayers().get(id);
        if(player != null) {
            player.setKills(player.getKills() + 1);
        }else{
            player = game.getTeam2().getPlayers().get(id);
            if(player != null)
                player.setKills(player.getKills()+1);
        }
    }

    public void incrementPlayerDeaths(int id){
        Player player = game.getTeam1().getPlayers().get(id);
        if(player != null){
            player.setDeaths(player.getDeaths()+1);
        }else{
            player = game.getTeam2().getPlayers().get(id);
            if(player != null)
                player.setDeaths(player.getDeaths()+1);
        }
    }
}
