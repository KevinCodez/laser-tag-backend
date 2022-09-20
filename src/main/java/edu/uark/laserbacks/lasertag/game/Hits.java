package edu.uark.laserbacks.lasertag.game;

import edu.uark.laserbacks.lasertag.player.Player;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Hits {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Player shooter;
    @ManyToOne
    private Player tagged;
}
