package edu.uark.laserbacks.game;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Data
public class Game {
    private Integer id;
    private boolean running;
    private Team team1;
    private Team team2;
    private List<String> killFeed;

    public Game() {
        init();
    }

    public void init(){
        id = new Random().nextInt(Integer.SIZE - 1);
        killFeed = new ArrayList<>();
    }

    public void setTeams(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
    }

}