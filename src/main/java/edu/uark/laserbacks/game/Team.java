package edu.uark.laserbacks.game;

import edu.uark.laserbacks.player.Player;
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

