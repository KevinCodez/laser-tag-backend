package edu.uark.laserbacks.lasertag.player;

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
        return repo.findByCodeName(codeName);
    }

    public Optional<Player> getPlayerByID(Integer id) {
        return repo.findById(id);
    }
}
