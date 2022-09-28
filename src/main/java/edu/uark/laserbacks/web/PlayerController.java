package edu.uark.laserbacks.web;

import edu.uark.laserbacks.player.Player;
import edu.uark.laserbacks.player.PlayerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping(path = "/player")
public class PlayerController {
    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Player>> getById(@PathVariable String id) {
        return new ResponseEntity<>(service.getPlayerByID(Integer.valueOf(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        service.deletePlayer(Integer.valueOf(id));
        return new ResponseEntity<>(null,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Player>> getPlayers() {
        return new ResponseEntity<>(service.getAllPlayers(), HttpStatus.OK);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<Player> getPlayerByCodeName(@RequestParam String codeName) {
        return new ResponseEntity<>(service.getPlayerByCodeName(codeName), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Player> newPlayer(@RequestBody PlayerForm playerForm, UriComponentsBuilder b) {
        Player player = service.createPlayer(playerForm);
        if (player != null) {
            return ResponseEntity.created(
                    b.path("/player/{id}").buildAndExpand(player.getId()).toUri()).build();
        }
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
    }
}
