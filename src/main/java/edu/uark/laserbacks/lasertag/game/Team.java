package edu.uark.laserbacks.lasertag.game;

import edu.uark.laserbacks.lasertag.player.Player;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Team {
    @Id @GeneratedValue
    private Integer id;
    private Integer gameID;
    @OneToMany
    private Set<Player> players;
}

