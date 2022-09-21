package edu.uark.laserbacks.lasertag.web;

import edu.uark.laserbacks.lasertag.player.Player;
import edu.uark.laserbacks.lasertag.player.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/player")
public class PlayerController {
    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    public Optional<Player> getById(@PathVariable String id) {
        return service.getPlayerByID(Integer.valueOf(id));
    }

    @GetMapping
    public List<Player> getPlayers(){
        return service.getAllPlayers();
    }

    @GetMapping(path = "/search")
    public Player getPlayerByCodeName(@RequestParam String codeName) {
        return service.getPlayerByCodeName(codeName);
    }
}
