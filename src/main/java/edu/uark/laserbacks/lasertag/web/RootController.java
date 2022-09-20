package edu.uark.laserbacks.lasertag.web;

import edu.uark.laserbacks.lasertag.player.Player;
import edu.uark.laserbacks.lasertag.player.PlayerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {
    private final PlayerRepository repo;

    public RootController(PlayerRepository repo) {
        this.repo = repo;
    }

    @GetMapping(path = "/player")
    public Player getPlayer(@RequestParam String codeName){
        return repo.findByCodeName(codeName);
    }
}
