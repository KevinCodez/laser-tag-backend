package edu.uark.laserbacks.web;

import edu.uark.laserbacks.player.Player;
import edu.uark.laserbacks.player.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/")
public class RootController {
    private final PlayerService service;

    public RootController(PlayerService service) {
        this.service = service;
    }

    public ResponseEntity<List<Player>> getIndex() {
        return new ResponseEntity<>(service.getAllPlayers(), HttpStatus.OK);
    }
}
