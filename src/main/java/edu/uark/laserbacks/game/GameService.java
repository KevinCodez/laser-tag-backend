package edu.uark.laserbacks.game;

import edu.uark.laserbacks.player.Player;
import edu.uark.laserbacks.player.PlayerService;
import lombok.Getter;
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

    public void registerHit(Integer shooter, Integer hit) {
        incrementPlayerKills(shooter);
        incrementPlayerDeaths(hit);
        game.getKillFeed().add(String.format("%s shot %s", getPlayer(shooter).getCodename(), getPlayer(hit).getCodename()));
    }

    // Score manipulation methods(these may need to be moved to the game class depending on how frontend data is received)
    public void incrementPlayerKills(int id) {
        Player player = getPlayer(id);
        player.setKills(player.getKills() + 1);
    }

    public void incrementPlayerDeaths(int id) {
        Player player = getPlayer(id);
        player.setDeaths(player.getDeaths() + 1);
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