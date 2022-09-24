package edu.uark.laserbacks.player;

import edu.uark.laserbacks.web.PlayerForm;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PlayerService {
    private final PlayerRepository repo;

    public PlayerService(PlayerRepository repo) {
        this.repo = repo;
    }

    public List<Player> getAllPlayers() {
        return repo.findAll();
    }

    public Player getPlayerByCodeName(String codeName) {
        return repo.findByCodename(codeName);
    }

    public Optional<Player> getPlayerByID(Integer id) {
        return repo.findById(id);
    }

    public Player createPlayer(PlayerForm form) {
        Player player = repo.findByCodename(form.getCodeName());
        if (player == null){
            player = new Player();
            player.setCodename(form.getCodeName());
            player.setFirstName(form.getFirstName());
            player.setLastName(form.getLastName());
            repo.save(player);
        }
        return player;
    }

    public void deletePlayer(Integer playerId) {
        repo.deleteById(playerId);
    }
}
