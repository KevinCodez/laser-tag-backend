package edu.uark.laserbacks.game;

import edu.uark.laserbacks.player.Player;
import edu.uark.laserbacks.player.PlayerService;
import lombok.Getter;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Service
public class GameService {
    private final Game game;
    private final PlayerService playerService;

    public GameService(Game game, PlayerService playerService) {
        this.game = game;
        this.playerService = playerService;
    }

    public void registerHit(Integer shooterId, Integer hitId) {
        Player shooter = getPlayer(shooterId);
        Player killed = getPlayer(hitId);
        if(shooter != null && killed != null){
            shooter.setKills(shooter.getKills()+1);
            killed.setDeaths(killed.getDeaths()+1);
            game.getKillFeed().add(String.format("%s shot %s", getPlayer(shooterId).getCodename(), getPlayer(hitId).getCodename()));
        }
    }

    Player getPlayer(Integer id) {
        Player player = game.getTeam1().getPlayers().get(id);
        if (player != null) {
            return player;
        } else {
            player = game.getTeam2().getPlayers().get(id);
            if (player != null)
                return player;
        }
        return null;
    }


    public Team createTeam(List<Integer> playerIds) {
        List<Player> players = new ArrayList<>(playerIds.size());
        for (Integer id : playerIds) {
            Optional<Player> player = playerService.getPlayerByID(id);
            player.ifPresent(players::add);
        }
        return new Team(players);
    }
}