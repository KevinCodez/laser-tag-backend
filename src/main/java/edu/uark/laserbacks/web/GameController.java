package edu.uark.laserbacks.web;

import edu.uark.laserbacks.game.GameService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/game")
public class GameController {
    private final GameService service;

    public GameController(GameService service){
        this.service = service;
    }
}
