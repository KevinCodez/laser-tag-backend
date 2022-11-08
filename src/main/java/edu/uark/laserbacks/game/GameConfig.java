package edu.uark.laserbacks.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfig {
    @Bean(name = "game")
    public Game singletonGame(){
        return new Game();
    }
}
