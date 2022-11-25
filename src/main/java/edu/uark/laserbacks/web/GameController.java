package edu.uark.laserbacks.web;

import edu.uark.laserbacks.game.Game;
import edu.uark.laserbacks.game.GameService;
import edu.uark.laserbacks.game.UdpServer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/game")
public class GameController {
    private final Game game;
    private final GameService service;
    private final UdpServer udpServer;

    public GameController(Game game, GameService service, UdpServer udpServer){
        this.game = game;
        this.service = service;
        this.udpServer = udpServer;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Game> getGame(@PathVariable Integer id) {
        if(game.getId().equals(id)) {
            return ResponseEntity.ok(game);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> stopGame(@PathVariable Integer id) {
        if(game.getId().equals(id)) {
            game.setRunning(false);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Game> createGame(@RequestBody CreateGameForm form) {
        if(form != null) {
            game.setTeam1(service.createTeam(form.team1));
            game.setTeam2(service.createTeam(form.team2));
            return ResponseEntity.ok(game);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping(path = "/{id}/start")
    public ResponseEntity<Game> startGame(@PathVariable Integer id) {
        if(game.getId().equals(id)) {
            game.setRunning(true);
            udpServer.start();
            return ResponseEntity.ok(game);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}