package edu.uark.laserbacks.game;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Game {
    private Team team1;
    private Team team2;

    public void setTeams(Team team1, Team team2){
        this.team1 = team1;
        this.team2 = team2;
    }
    public List<Team> getTeams(){
        List<Team> teams = new ArrayList<Team>();
        teams.add(team1);
        teams.add(team2);

        return teams;
    }
}