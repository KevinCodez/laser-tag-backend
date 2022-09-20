package edu.uark.laserbacks.lasertag.game;

import edu.uark.laserbacks.lasertag.player.Player;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Team {
    @Id @GeneratedValue
    private Integer id;
    @OneToOne
    private Game game;
    private String teamName;
    @OneToMany
    private Set<Player> players;
}

