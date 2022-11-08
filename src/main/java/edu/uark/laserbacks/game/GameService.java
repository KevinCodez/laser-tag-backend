package edu.uark.laserbacks.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private Game game;

    public GameService(Game game){
        this.game = game;
        //game.setTeams();
    }

    // Increment team score method
    // Increment player score method
}
